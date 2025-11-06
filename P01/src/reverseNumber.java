import java.util.Scanner;

public class reverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        String numbeString = Integer.toString(number);
        Integer run = 1;
        String ans = "";
        if (number < 0) {
            System.out.println();
        } else {
            while (numbeString.length() >= run) {
                ans += numbeString.charAt(numbeString.length()-run);
                run++;
            }
            System.out.println(Integer.parseInt(ans));
        }
    }
    
}
