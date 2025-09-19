import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<List<String>> courses = new ArrayList<>();
        int n = sc.nextInt();
        double maxSimilarity = -1;
        String bestPair = "";
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
            List<String> courseList = Arrays.asList(sc.nextLine().split(" "));
            courses.add(courseList);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<String> set1 = new HashSet<>(courses.get(i));
                Set<String> set2 = new HashSet<>(courses.get(j));

                Set<String> intersection = new HashSet<>(set1);
                intersection.retainAll(set2);

                Set<String> union = new HashSet<>(set1);
                union.addAll(set2);

                double similarity = (double) intersection.size() / union.size();

                String name1 = names.get(i);
                String name2 = names.get(j);
                String currentPair;
                if (name1.compareTo(name2) < 0) {
                    currentPair = name1 + " " + name2;
                } else {
                    currentPair = name2 + " " + name1;
                }

                if (similarity > maxSimilarity) {
                    maxSimilarity = similarity;
                    bestPair = currentPair;
                } else if (similarity == maxSimilarity) {
                    if (currentPair.compareTo(bestPair) < 0) {
                        bestPair = currentPair;
                    }
                }
            }
        }

        System.out.printf("%s %.2f\n", bestPair, maxSimilarity);
    }
}