public class specialPrime {
    public static void main(String[] args) {
        int num = 10;
        while (num>=10 && num <= 1000) {
            if (num>=2){
                int i = 2;
                boolean isPrime = true;
                while(i<num) {
                    if (num % i == 0) {
                        isPrime = false;
                    }
                    i++;
                }
                if (isPrime && num % 10 != 9) {
                    System.out.println(num);
                }
            }
            num++;
        }
    }
}