import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入帳戶：");
        String account = sc.nextLine();
        System.out.print("請輸入密碼：");
        String password = sc.nextLine();

        Member member = new Member(account,password,"user");
        System.out.println("成功登入" + "歡迎" + member.name);
        Library manages = new Library();
        manages.addBook();

        while (true){
            member.getIofo();
            String userAnswer = sc.nextLine();
            int answer = member.UserAnswer(userAnswer);
            manages.runbook(userAnswer);
            if (answer == 3){
                break;
            }
        }
    }
}