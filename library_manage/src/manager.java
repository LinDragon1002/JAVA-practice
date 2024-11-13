public class manager extends Member{
    public manager(String account,String password,String name){
        super(account,password,name);
    }

    @Override
    public void getIofo(){
        System.out.println("請問你需要甚麼幫助？");
        System.out.print("A：新增書籍　");
        System.out.print("B：刪除書籍　");
        System.out.print("C：查詢書籍　");
        System.out.println("D：退出");
    }

    @Override
    public int UserAnswer(String userAnswer){
        if (userAnswer.equals("A")) {
            return 0;
        } else if (userAnswer.equals("B")) {
            return 1;
        }else if (userAnswer.equals("C")){
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
