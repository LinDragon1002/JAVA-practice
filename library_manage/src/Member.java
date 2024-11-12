import java.util.Scanner;

public class Member {
    String account;
    String password;
    String name;

    public Member(String account,String password,String name){
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public int checkMember(){
        Scanner sc = new Scanner(System.in);
        int check = 0 ;
        while (true){
            System.out.print("請輸入帳戶：");
            String account = sc.nextLine();
            System.out.print("請輸入密碼：");
            String password = sc.nextLine();
            if (account.equals(this.account)){
                if (password.equals(this.password)){
                    System.out.println("成功登入" + "歡迎" + name);
                    break;
                }else if (password.equals("none")){
                    System.out.println("謝謝下次蒞臨");
                    check = 1;
                    break;
                }else{
                    System.out.println("登入失敗，密碼有誤");
                }
            }else if (account.equals("none")){
                System.out.println("謝謝下次蒞臨");
                check = 1;
                break;
            }else{
                System.out.println("登入失敗，查無此帳號");
            }
        }
        return check;
    }

    public void getIofo(){
        System.out.println("請問你需要甚麼幫助？");
        System.out.print("A：借書　");
        System.out.print("B：還書　");
        System.out.print("C：查詢書籍　");
        System.out.println("D：退出");
    }

    public int UserAnswer(String userAnswer){
        if (userAnswer.equals("A")) {
            System.out.println("請問" + this.name + "想要藉哪本書籍？");
            return 0;
        } else if (userAnswer.equals("B")) {
            System.out.println("請問" + this.name + "想要還哪本書籍？");
            return 1;
        } else if (userAnswer.equals("C")) {
            System.out.println("請問" + this.name + "想要查詢哪本書籍？");
            return 2;
        } else if (userAnswer.equals("D")) {
            System.out.println("謝謝" + this.name + "下次蒞臨");
            return 3;
        } else {
            System.out.println("輸入錯誤，請重新輸入");
            System.out.println("請輸入大寫A~D");
            return 4;
        }
    }
}
