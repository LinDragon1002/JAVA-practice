public class App {
    public static void main(String[] args) {
        LightController controller = new LightController();

        System.out.println("測試案例 1: 基本開關功能");
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");
        controller.controlLight("ikea", "on");
        controller.controlLight("osram", "on");
        controller.controlLight("yeelight", "on");

        System.out.println("\n測試案例 2: 亮度調節功能");
        controller.setBrightness("philips", 80);
        controller.setBrightness("xiaomi", 90);
        controller.setBrightness("ikea", 75);
        controller.setBrightness("osram", 85);
        controller.setBrightness("yeelight", 70);
        controller.setBrightness("yeelight", 70);

        System.out.println("\n測試案例 3: 色溫調節功能");
        controller.setColorTemperature("philips", 2700);
        controller.setColorTemperature("xiaomi", 5000);
        controller.setColorTemperature("osram", 4000);
        controller.setColorTemperature("yeelight", 3500);

        System.out.println("\n測試案例 4: 錯誤輸入測試");
        controller.setBrightness("philips", 150); // 超出範圍
        controller.controlLight("unknown", "on"); // 不支援品牌

        controller.showAllLightStatus();
    }
}