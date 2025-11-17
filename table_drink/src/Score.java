import java.util.*;

public class Score {
    private String name;
    private List<Integer> scores;
    private int age;

    // 建構元
    public Score(String name, List<Integer> scores, int age) {
        this.name = name;
        this.scores = new ArrayList<>(scores);
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for scores
    public List<Integer> getScores() {
        return new ArrayList<>(scores);
    }

    // Setter for scores
    public void setScores(List<Integer> scores) {
        this.scores = new ArrayList<>(scores);
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // 計算平均分數
    public float average() {
        List<Integer> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores);

        if (sortedScores.size() >= 5) {
            // 去除最低分和最高分
            sortedScores.remove(0); // 移除最低分
            sortedScores.remove(sortedScores.size() - 1); // 移除最高分
        } else {
            // 去除 1 個最低分
            sortedScores.remove(0);
        }

        // 計算平均
        double sum = 0;
        for (int score : sortedScores) {
            sum += score;
        }
        double avg = sum / sortedScores.size();

        // 四捨五入至小數一位
        return Math.round(avg * 10) / 10.0f;
    }

    // 判斷等級
    public String rank() {
        float avg = average();

        if (avg > 90) {
            return "A+";
        } else if (avg > 80) {
            return "A";
        } else if (avg > 70) {
            return "B";
        } else if (avg > 60) {
            return "C";
        } else {
            return "D";
        }
    }
}
