public class IdolMovie extends Movie {
    private LightStick lightStick;
    
    // 建構元：呼叫父類建構元，將電影類別固定為"紀錄片"，並設定螢光棒
    public IdolMovie(String name, int price, String rating, String time, LightStick lightStick) {
        super(name, "紀錄片", price, rating, time);
        this.lightStick = lightStick;
    }
    
    // 公開方法：回傳螢光棒的顏色
    public String getLightColor() {
        return lightStick.getColor();
    }
}
