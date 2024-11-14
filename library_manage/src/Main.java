import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎使用本圖書館系統");

        Member member = new Member("user","123456","user");
        Member manager = new Manager("manager","654321","manager");
        Library manages = new Library();
        manages.allBook();
        boolean rely = false;

        while (!rely){
            System.out.println("請選擇以下登入方式：");
            System.out.print("A：使用者　");
            System.out.println("B：管理員");
            String choose = sc.nextLine();
            if (choose.equals("A")){
                rely = member.checkMember();
                if (!rely){
                    while (true){
                        member.getIofo();
                        System.out.println("現在有"+manages.books.size()+"本書");
                        String userAnswer = sc.nextLine();
                        int answer = member.UserAnswer(userAnswer);
                        manages.runBook(userAnswer);
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