import java.util.Scanner;

public class Pra1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n1 = sc.nextInt();
        Integer n2 = sc.nextInt();
        Integer n3 = sc.nextInt();
        if(n1 > n2 && n1 > n3) {
            if (n2 > n3) {
                System.out.println(n1+">"+n2+">"+n3);
            }else {
                System.out.print(n1+">"+n3+">"+n2);
            }
            
        } else if (n2 > n1 && n2 > n3) {
            if (n1 > n3){
               System.out.println(n2+">"+n1+">"+n3); 
            }else {
                System.out.println(n2+">"+n3+">"+n1);
            }
            
        } else if (n3 > n1 && n3 > n2) {
            if (n1 > n2) {
                System.out.println(n3+">"+n1+">"+n2);
            } else {
                System.out.println(n3+">"+n2+">"+n1);
            }
        }
                
    }
}
