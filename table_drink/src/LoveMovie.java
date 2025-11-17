public class LoveMovie extends Movie {
    
    // 建構元：呼叫父類建構元，將電影類別固定為"愛情片"
    public LoveMovie(String name, int price, String rating, String time) {
        super(name, "愛情片", price, rating, time);
    }
    
    // 覆寫 toString()，回傳內容為：這是一部{電影類別}
    @Override
    public String toString() {
        return "這是一部" + getType();
    }
}
