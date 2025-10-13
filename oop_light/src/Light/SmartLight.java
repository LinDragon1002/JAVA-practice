package Light;

public interface SmartLight {
    void turnOn(); // 開燈
    void turnOff(); // 關燈
    int getBrightness(); // 取得亮度
    void setBrightness(int level); // 調整亮度 (1-100)
    String getBrand(); // 取得品牌名稱
    boolean isOn(); // 取得燈具狀態
}
