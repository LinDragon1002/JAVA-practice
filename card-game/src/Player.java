public class Player{
    String account;
    String password;
    String name;
    int rank;
    int Exp;
    int totalExp;
    public Player(String account, String password, String name){
        this.account = account;
        this.password = password;
        this.name = name;
        rank = 1;
        Exp = 0;
        totalExp = 1000;
    }
    public void getInfo(){
        System.out.println("---------");
        System.out.println("玩家:" + this.name);
        System.out.println("---------");
        System.out.println("等級:" + this.rank);
        System.out.println("經驗值:" + this.Exp + "/" + totalExp);
        System.out.println("---------");
    }
    public void addExp(int Exp){
        this.rank = Exp / totalExp + 1;
        this.Exp = Exp % totalExp;
        if (this.rank > 1){
            System.out.println("你已上升到" + this.rank + "級");
        }
    }
}
