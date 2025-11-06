import java.util.Scanner;

public class FIBPRESEQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        Integer temp1 = 1;
        Integer temp2 = 1;
        Integer run = 2;
        Integer ans = 0;
        String ans_list = "1,1";
        if (number == 0) {
            System.out.println();
        } else if (number == 1) {
            System.out.println("1");
        } else {
            while (number > run) {
                ans = temp1 + temp2;
                temp1 = temp2;
                temp2 = ans;
                ans_list +=  "," + Integer.toString(ans);
                run++;
            }
            System.out.println(ans_list);
        }
        
    }
    
}
