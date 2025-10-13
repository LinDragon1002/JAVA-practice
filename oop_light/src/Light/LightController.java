package Light;

import java.util.HashMap;
import java.util.Map;

public class LightController {
    private Map<String, SmartLight> lights = new HashMap<>();

    public LightController() {
        lights.put("philips", new PhilipsLight());
        lights.put("xiaomi", new XiaomiLight());
    }

    public void controlLight(String brand, String action) {
        SmartLight light = lights.get(brand.toLowerCase());
        if (light == null) {
            System.out.println("不支援的品牌: " + brand);
            return;
        }

        switch (action.toLowerCase()) {
            case "on":
                light.turnOn();
                break;
            case "off":
                light.turnOff();
                break;
            default:
                System.out.println("無效的動作: " + action);
        }
    }

    public void setBrightness(String brand, int level) {
        SmartLight light = lights.get(brand.toLowerCase());
        if (light == null) {
            System.out.println("不支援的品牌: " + brand);
            return;
        }

        light.setBrightness(level);
    }

    public void showAllLightStatus() {
        System.out.println("=== 所有燈具狀態總覽 ===");
        for (SmartLight light : lights.values()) {
            String status = light.isOn() ? "ON" : "OFF";
            System.out.println(light.getBrand() + ": " + status +
                    " | 亮度: " + light.getBrightness() + "%");
        }
    }
}
