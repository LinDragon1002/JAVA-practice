import java.util.Scanner;

public class simplecal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number1 = sc.nextInt();
        String temp1 = sc.next();
        Integer number2 = sc.nextInt();
        if (temp1.contains("+")) {
            System.out.println(number1 + "+" + number2 + "=" + (number1+number2));
        } else if (temp1.contains("-")) {
            System.out.println(number1 + "-" + number2 + "=" + (number1-number2));
        } else if (temp1.contains("/") && number2 != 0) {
            double ans = (double) number1/number2;
            System.out.println(number1 + "/" + number2 + "=" + String.format("%.2f", ans));
        } else if (temp1.contains("*")) {
            System.out.println(number1 + "*" + number2 + "=" + (number1*number2));
        } else {
            System.out.println("error");
        }
    }
    
}
