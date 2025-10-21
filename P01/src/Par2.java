import java.util.Scanner;

public class Par2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double height = sc.nextDouble();
        Double weight = sc.nextDouble();
        Double BMI = weight / Math.pow(height / 100, 2);
        System.out.format("%.2f",BMI);
        System.out.println();
        if (BMI >= 18.5 && BMI < 24) {
            System.out.println("正常");
        } else if (BMI >= 24 && BMI < 27) {
            System.out.println("過重");
        } else if (BMI >= 27 && BMI < 30) {
            System.out.println("輕度肥胖");
        } else if (BMI >= 30 && BMI < 35) {
            System.out.println("中度肥胖");
        } else if (BMI >= 35) {
            System.out.println("重度肥胖");
        } else if (BMI < 18.5) {
            System.out.println("體重過輕");
        }
    }
}
