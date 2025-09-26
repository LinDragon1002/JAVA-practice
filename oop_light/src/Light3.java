import java.util.*;

// 給學生的起始框架
class LightController3 {
    // 新增功能需求：
    // setBrightness(brand, level) - level 1-100
    // setColorTemperature(brand, temp) - temp 2700-6500K

    // 新品牌輸出格式：
    // Osram: "💡 Osram專業燈具[動作]"
    // Yeelight: "🌈 Yeelight智慧燈[動作]"
    List<String> brands = List.of("philips", "xiaomi", "ikea", "osram", "yeelight");
    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","專業燈具啟動","智慧燈啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉","專業燈具關閉","智慧燈關閉");
    List<List<String>> allLight = new ArrayList<>();
    List<String> temps = new ArrayList<>();

    public void controlLight(String brand, String action) {
        for (String brandLight : brands) {
            if (brandLight.equals(brand)) {
                temps.add(brand);
                if (action.equals("on")) {
                    temps.add("開燈");
                    temps.add(msg.get(brands.indexOf(brand)));
                } else if (action.equals("off")) {
                    temps.add("關燈");
                    temps.add(msg.get(brands.indexOf(brand)+brands.size()));
                }
                allLight.add(new ArrayList<>(temps));
                temps.clear();
                break;
            }
        }
    }

    // 還要加這些方法...
    public void setBrightness(String brand, int level) {
        for (List<String> light : allLight) {
            if (light.get(0).equals(brand)) {
                if (level > 0 && level < 101) {
                    light.add("亮度:"+String.valueOf(level));
                } else {
                    light.add("超出範圍");
                }
            }
        }

    }

    public void setColorTemperature(String brand, int temp) {
        for (List<String> light : allLight) {
            if (light.get(0).equals(brand)) {
                if (temp >= 2700 && temp <= 6500) {
                    light.add("溫度:"+String.valueOf(temp));
                } else {
                    light.add("超出範圍");
                }
            }
        }


    }

    public void showAllLightStatus() {
        // 提示：顯示所有燈具的狀態總覽
        for (List<String> light : allLight) {
            String brand = light.get(0);
            String action = light.get(1);
            String message = light.get(2);
            String brightness = light.size() > 3 ? "，"+light.get(3) : "";
            String colorTemp = light.size() > 4 ? "，"+light.get(4) : "";

            System.out.println("當" + brand + action + "輸出:" + brand + message + brightness + colorTemp);
        }

    }

}




public class Light3 {
    public static void main(String[] args) {
        LightController3 controller = new LightController3();

        // 測試用的main方法
        // 測試所有新功能
        System.out.println("\n📋 測試案例 1: 基本開關功能");
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");
        controller.controlLight("ikea", "on");
        controller.controlLight("osram", "on");
        controller.controlLight("yeelight", "on");

        System.out.println("\n📋 測試案例 2: 亮度調節功能");
        controller.setBrightness("philips", 80);
        controller.setBrightness("xiaomi", 90);
        controller.setBrightness("osram", 75);
        controller.setBrightness("yeelight", 85);

        System.out.println("\n📋 測試案例 3: 色溫調節功能");
        controller.setColorTemperature("philips", 3000);
        controller.setColorTemperature("xiaomi", 4000);
        controller.setColorTemperature("ikea", 2700);
        controller.setColorTemperature("yeelight", 5000);

        System.out.println("\n📋 測試案例 4: 錯誤輸入測試");
        controller.setBrightness("philips", 150); // 超出範圍
        controller.setColorTemperature("xiaomi", 1000); // 超出範圍
        controller.controlLight("unknown", "on"); // 不支援品牌

        controller.showAllLightStatus(); // 要輸出status、brightness和colorTemp
    }
}
