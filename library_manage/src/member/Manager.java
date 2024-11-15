//包裝到member資料夾
package member;

//繼承Member的class
public class Manager extends Member {
    public Manager(String account, String password, String name) {
        super(account, password, name);
    }

    //複寫並改成管理者的資訊
    @Override
    public void getIofo() {
        System.out.println("請問你需要甚麼幫助？");
        System.out.print("A：新增書籍　");
        System.out.print("B：刪除書籍　");
        System.out.print("C：查詢書籍　");
        System.out.println("D：退出");
    }

    //複寫並檢查使用者輸入是否正確和告知使用者下一步要做的資訊
    @Override
    public int UserAnswer(String userAnswer) {
        switch (userAnswer.toUpperCase()) {
            case "A":
                return 0;
            case "B":
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
