import java.util.Scanner;

public class sumthenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        Integer run = number;
        Integer ans = 0;
        if (number < 0) {
            while (run < 0) {
                ans += run;
                run++;
            }
        } else {
            run = 1;
            while (number >= run) {
                ans += run;
                run++;
            }
        }
        System.out.println(ans);
    }
    
}
