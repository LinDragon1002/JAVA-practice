import java.util.Scanner;

public class POWER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        Integer run = 1;
        Long ans = 1L;
        while (number > run) {
            run++;
            ans *= run; 
        }
        System.out.println(ans);
    }
    
}
