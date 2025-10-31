import java.util.Scanner;

public class Par3 {
    // 使用者輸入兩個整數(正負大小位置不一定)，假設為m,n
    // m<n，輸出m~n之間的整數
    // m>n，也輸出m~n之間的整數(變成存大到小的輸出)
    // m,n相等時輸出m
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer m = sc.nextInt();
        Integer n = sc.nextInt();
        Integer start = m;
        if (m < n) {
            while (start<=n){
                System.out.println(start);
                start++;
            }
        } else if (m > n) {
            while (start>=n) {
                System.out.println(start);
                start--;
            }
        } else {
            System.out.println(m);
        }
    }
    
}
