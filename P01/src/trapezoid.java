import java.util.Scanner;

public class trapezoid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b=sc.nextInt();
        if (a < b){
            for (int i=a; i<=b; i++){
                for (int j=0; j<i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        else if (a > b){
            for (int i=a; i>=b; i--){
                for (int j=0; j<i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        else{
            for (int i=0; i<a; i++){
                System.out.print("*");
            }
        }

        // if (a < b) {
        //     int i = a;
        //     while (i <= b) {
        //         int j = 0;
        //         while (j < i) {
        //             System.out.print("*");
        //             j++;
        //         }
        //         System.out.println();
        //         i++;
        //     }
        // }
        // else if (a > b) {
        //     int i = a;
        //     while (i >= b) {
        //         int j = 0;
        //         while (j < i) {
        //             System.out.print("*");
        //             j++;
        //         }
        //         System.out.println();
        //         i--;
        //     }
        // }
        // else {
        //     int i = 0;
        //     while (i < a) {
        //         System.out.print("*");
        //         i++;
        //     }
        // }
    }
}