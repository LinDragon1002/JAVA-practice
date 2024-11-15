//引入資料夾裡面的.java
import manage.Library;
import member.Manager;
import member.Member;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎使用本圖書館系統");

        //新增管理員和使用者帳號密碼
        Member member = new Member("user","123456","user");
        Member manager = new Manager("manager","654321","manager");

        Library manages = new Library();
        //先把原本圖書館有的書加入到list
        manages.allBook();

        //判斷是否繼續執行下一步程式
        boolean rely = false;

        while (!rely){
            System.out.println("請選擇以下登入方式：");
            System.out.print("A：使用者　");
            System.out.println("B：管理員");
            String choose = sc.nextLine().toUpperCase();

            //判斷是使用者或是管理員
            if (choose.equals("A")){

                //判斷帳號密碼有沒有輸入正確
                rely = member.checkMember();
                if (!rely){
                    while (true){
                        //詢問使用者想要執行哪一個選項
                        member.getIofo();
                        //告知使用者現在有多少本書在圖書館裡面
                        System.out.println("現在有"+manages.books.size()+"本書");
                        //使用者輸入想要執行哪一個選項
                        String userAnswer = sc.nextLine();
                        //判斷使用者輸入的選項，並詢問下一步的動作
                        int answer = member.UserAnswer(userAnswer);
                        //去library.java去尋找資料
                        manages.runBook(userAnswer);
                        //判斷是否退出
                        if (answer == 3){
                            break;
                        }
                    }
                    rely = true;
                }
            }else if (choose.equals("B")){
                rely = manager.checkMember();
                if (!rely){
                    while (true){
                        manager.getIofo();
                        System.out.println("現在有"+manages.books.size()+"本書");
                        String userAnswer = sc.nextLine();
                        int answer = manager.UserAnswer(userAnswer);
                        manages.addBook(answer);
                        if (answer == 3){
                            break;
                        }
                    }
                    rely = true;
                }
            }else{
                System.out.println("請重新輸入");
            }
        }
    }
}