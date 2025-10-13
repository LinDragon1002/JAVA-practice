package Light;

public class Light {
    public static void main(String[] args) {
        LightController controller = new LightController();

        System.out.println("測試案例 1: 基本開關功能");
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");

        System.out.println("\n測試案例 2: 亮度調節功能");
        controller.setBrightness("philips", 80);
        controller.setBrightness("xiaomi", 90);

        System.out.println("\n測試案例 3: 錯誤輸入測試");
        controller.setBrightness("philips", 150); // 超出範圍
        controller.controlLight("unknown", "on"); // 不支援品牌

        System.out.println();
        controller.showAllLightStatus(); // 輸出完整狀態
    }
}
