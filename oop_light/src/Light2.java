import java.util.*;

// 給學生的起始框架
class LightController2 {
    List<String> brands = List.of("philips", "xiaomi", "ikea");
    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉");
    List<List<String>> allLight = new ArrayList<>();
    List<String> temps = new ArrayList<>();

    public void controlLight(String brand, String action) {
        try {
            temps.add(brand);
            // 直接檢查品牌是否存在
            if (!brands.contains(brand)) {
                throw new IllegalArgumentException();
            }
            
            int exitingBrand = 0;
            for (List<String> light : allLight) {
                if (light.get(0).equals(brand)) {
                    if (action.equals("on")) {
                        light.set(1, "開燈");
                        light.set(2, msg.get(brands.indexOf(brand)));
                    } else if (action.equals("off")) {
                        light.set(1, "關燈");
                        light.set(2, msg.get(brands.indexOf(brand) + brands.size()));
                    }
                    exitingBrand = 1;
                    break;
                }
            }
            if (exitingBrand == 0) {
                if (action.equals("on")) {
                    temps.add("開燈");
                    temps.add(msg.get(brands.indexOf(brand)));
                } else if (action.equals("off")) {
                    temps.add("關燈");
                    temps.add(msg.get(brands.indexOf(brand)+brands.size()));
                }
                allLight.add(new ArrayList<>(temps));
            }

            temps.clear();

        } catch (Exception e) {
            temps.add("不支援此產品");
            allLight.add(new ArrayList<>(temps));
            temps.clear();
        }
    }

    public void showAllLightStatus() {
        // 提示：顯示所有燈具的狀態總覽
        for (List<String> light : allLight) {
            String brand = light.get(0);
            String action = light.get(1);
            String message = light.size() >= 2 ? light.get(2) : "";

            System.out.println("當" + brand + action + "輸出:" + brand + message);
        }
    }
}




public class Light2 {
    public static void main(String[] args) {
        LightController2 controller = new LightController2();

        // 第一波測試：基本開關功能
        System.out.println("📋 測試案例 1: 基本開關功能");
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");
        controller.controlLight("ikea", "on");
        controller.showAllLightStatus();

        // 第二波測試：關燈功能
        System.out.println("\n📋 測試案例 2: 關燈功能");
        controller.controlLight("xiaomi", "off");
        controller.showAllLightStatus();

        // 第二波測試：關燈功能
        System.out.println("\n📋 測試案例 3: 關燈功能");
        controller.controlLight("xiaomi", "off");
        controller.showAllLightStatus();

        // 第三波測試：關燈功能
        System.out.println("\n📋 測試案例 4: 關燈功能");
        controller.controlLight("xiaomi", "off");
        controller.showAllLightStatus();
    }
}
