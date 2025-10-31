import java.util.Scanner;

public class Par4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num>=2){
            int i = 2;
            // int count = 0;
            boolean isPrime = true;
            while(i<num) {
                if (num % i == 0) {
                    isPrime = false;
                }
                i++;
            }
            if (isPrime) {
                System.out.println("true");
            }else {
                System.out.println("no");
            }
        }
    }
    
}
