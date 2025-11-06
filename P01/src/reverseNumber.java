import java.util.Scanner;

public class reverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            if (num < 0) {
                break;
            }

            int ans = 0;
            while (num > 0){
                ans = ans * 10 + num % 10;
                num /= 10;
            }
            System.out.println(ans);
        }
    }
}