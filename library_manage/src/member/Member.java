//包裝到member資料夾
package member;

import java.util.Scanner;

//設定變數儲存帳號、密碼、姓名和登入檢查
public class Member {
    String account;
    String password;
    String name;
    int check = 1;

    public Member(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }

    //輸入帳號和密碼，檢查登入的帳號和密碼是否正確
    public boolean checkMember() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while (this.check > 0) {
            System.out.print("請輸入帳戶：");
            String account = sc.nextLine();
            System.out.print("請輸入密碼：");
            String password = sc.nextLine();
            validateAccount(account, password);
            if (this.check == 0){
                System.out.println("三次失敗，無法登入");
            }else if (this.check == -1){
                check = false;
            }
        }
        return check;
    }

    //檢查輸入的帳號和密碼是哪裡錯誤和提醒使用者錯誤幾次
    private void validateAccount(String account, String password) {
        if (account.equals(this.account)) {
            if (password.equals(this.password)) {
                System.out.println("成功登入" + "歡迎" + name);
                check = -1;
            } else {
                System.out.println("第" + check + "次錯誤　登入失敗，密碼有誤");
                check += 1;
            }
        } else {
            System.out.println("第" + check + "次錯誤　登入失敗，查無此帳號");
            check += 1;
        }
        if (check > 3){
            check = 0;
        }
    }

    //提供使用者下一步要做的資訊
    public void getIofo() {
        System.out.println("請問你需要甚麼幫助？");
        System.out.print("A：借書　");
        System.out.print("B：還書　");
        System.out.print("C：查詢書籍　");
        System.out.println("D：退出");
    }

    //檢查使用者輸入是否正確和告知使用者下一步要做的資訊
    public int UserAnswer(String userAnswer) {
        switch (userAnswer.toUpperCase()) {
            case "A":
                System.out.println("請問" + this.name + "想要藉哪本書籍？");
                return 0;
            case "B":
                System.out.println("請問" + this.name + "想要還哪本書籍？");
                return 1;
            case "C":
                System.out.println("請問" + this.name + "想要查詢哪本書籍？");
                return 2;
            case "D":
                System.out.println("謝謝" + this.name + "下次蒞臨");
                return 3;
            default:
                System.out.println("輸入錯誤，請重新輸入");
                System.out.println("請輸入大寫A~D");
                return 4;
        }
    }
}
