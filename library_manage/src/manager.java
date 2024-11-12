public class manager extends Member{
    public manager(String account,String password,String name){
        super(account,password,name);
    }

    @Override
    public void getIofo(){
        System.out.println("請問你需要甚麼幫助？");
        System.out.print("A：新增書籍　");
        System.out.print("B：刪除書籍　");
        System.out.println("C：退出");
    }

    @Override
    public int UserAnswer(String userAnswer){
        if (userAnswer.equals("A")) {
            System.out.print("請問" + this.name + "新增書籍名稱：");
            return 0;
        } else if (userAnswer.equals("B")) {
            System.out.print("請問" + this.name + "刪除書籍名稱：");
            return 1;
        } else if (userAnswer.equals("C")) {
            System.out.println("謝謝" + this.name + "下次蒞臨");
            return 2;
        } else {
            System.out.println("輸入錯誤，請重新輸入");
            System.out.println("請輸入大寫A~D");
            return 3;
        }
    }
}
