import java.util.HashMap;
import java.util.Map;

class LightController {
    private Map<String, SmartLight> lights = new HashMap<>();

    public LightController() {
        lights.put("philips", new PhilipsLight());
        lights.put("xiaomi", new XiaomiLight());
        lights.put("ikea", new IkeaLight());
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

    public void setColorTemperature(String brand, int temperature) {
        SmartLight light = lights.get(brand.toLowerCase());
        if (light == null) {
            System.out.println("不支援的品牌: " + brand);
            return;
        }
        light.setColorTemperature(temperature);
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
