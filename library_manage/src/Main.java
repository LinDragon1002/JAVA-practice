import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎使用本圖書館系統");

        Member member = new Member("user","123456","user");
        Member manager = new manager("manager","654321","manager");
        Library manages = new Library();
        manages.addBook();

        while (true){
            System.out.println("請選擇以下登入方式：");
            System.out.print("A：使用者　");
            System.out.println("B：管理員");
            String choose = sc.nextLine();
            if (choose.equals("A")){
                int rely = member.checkMember();
                if (rely == 0){
                    while (true){
                        member.getIofo();
                        String userAnswer = sc.nextLine();
                        int answer = member.UserAnswer(userAnswer);
                        manages.runBook(userAnswer);
                        if (answer == 3){
                            break;
                        }
                    }
                    break;
                }else{
                    break;
                }
            }else if (choose.equals("B")){
                int rely = manager.checkMember();
                if (rely == 0){
                    while (true){
                        manager.getIofo();
                        String userAnswer = sc.nextLine();
                        int answer = manager.UserAnswer(userAnswer);
                        manages.addBook(answer);
                        if (answer == 3){
                            break;
                        }
                    }
                    break;
                }else{
                    break;
                }
            }else{
                System.out.println("請重新輸入");
            }
        }
    }
}