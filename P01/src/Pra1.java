import java.util.Scanner;

public class Pra1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n1 = sc.nextInt();
        Integer n2 = sc.nextInt();
        Integer n3 = sc.nextInt();
        Integer maxn = Math.max(Math.max(n1,n2),n3);
        Integer minn = Math.min(Math.min(n1,n2),n3);
        
    }
}
