import java.util.*;

// 給學生的起始框架
//class LightController3 {
    // 新增功能需求：
    // setBrightness(brand, level) - level 1-100
    // setColorTemperature(brand, temp) - temp 2700-6500K

    // 新品牌輸出格式：
    // Osram: "💡 Osram專業燈具[動作]"
    // Yeelight: "🌈 Yeelight智慧燈[動作]"
//    List<String> brands = List.of("philips", "xiaomi", "ikea", "osram", "yeelight");
//    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","專業燈具啟動","智慧燈啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉","專業燈具關閉","智慧燈關閉");
//    List<List<String>> allLight = new ArrayList<>();
//    List<String> temps = new ArrayList<>();
//
//    public void controlLight(String brand, String action) {
//        try {
//            if (!brands.contains(brand)) {
//                throw new IllegalArgumentException();
//            }
//
//            int brandIndex = brands.indexOf(brand);
//            String status = action.equals("on") ? "開燈" : "關燈";
//            String message = msg.get(brandIndex + (action.equals("off") ? brands.size() : 0));
//
//            boolean updated = allLight.stream()
//                    .filter(light -> light.get(0).equals(brand))
//                    .findFirst()
//                    .map(light -> {
//                        light.set(1, status);
//                        light.set(2, message);
//                        return true;
//                    })
//                    .orElse(false);
//
//            if (!updated) {
//                allLight.add(new ArrayList<>(Arrays.asList(brand, status, message)));
//                temps.clear();
//            }
//        } catch (Exception e) {
//            allLight.add(new ArrayList<>(Arrays.asList("不支援此產品",brand)));
//            temps.clear();
//        }
//    }
//
//    // 還要加這些方法...
//    public void setBrightness(String brand, int level) {
//        allLight.stream()
//                .filter(light -> light.get(0).equals(brand))
//                .forEach(light -> {
//                    if (level >= 1 && level <= 100) {
//                        int index = -1;
//                        for (int i = 0; i < light.size(); i++) {
//                            if (light.get(i).contains("亮度")) {
//                                index = i;
//                                break;
//                            }
//                        }
//
//                        if (index != -1) {
//                            light.set(index, "亮度:" + level);
//                        } else {
//                            light.add("亮度:" + level);
//                        }
//                    }
//
//                });
//    }
//
//    public void setColorTemperature(String brand, int temp) {
//        allLight.stream()
//                .filter(light -> light.get(0).equals(brand))
//                .forEach(light -> {
//                    if (temp >= 2700 && temp <= 6500) {
//                        int index = -1;
//                        for (int i = 0; i < light.size(); i++) {
//                            if (light.get(i).contains("溫度")) {
//                                index = i;
//                                break;
//                            }
//                        }
//
//                        if (index != -1) {
//                            light.set(index, "溫度:" + temp);
//                        } else {
//                            light.add("溫度:" + temp);
//                        }
//                    }
//                });
//    }
//
//    public void showAllLightStatus() {
//        // 提示：顯示所有燈具的狀態總覽
//        for (List<String> light : allLight) {
//            if (light.get(0).contains("不支援此產品")) {
//                System.out.println(light.get(1)+light.get(0));
//            } else {
//                String brand = light.get(0);
//                String action = light.get(1);
//                String message = light.size() > 2 ? "，"+light.get(2) : "";
//                String brightness = light.size() > 3 ? "，"+light.get(3) : "";
//                String colorTemp = light.size() > 4 ? "，"+light.get(4) : "";
//
//                System.out.println("當" + brand + action + "輸出:" + brand + message + brightness + colorTemp);
//            }
//        }
//
//    }

//}
class LightController3 {
    // 需求：根據brand參數控制不同品牌的燈
    // brand可能的值："philips", "xiaomi", "ikea"
    // action可能的值："on", "off"

    private Map<String, String> lightStatus = new HashMap<>(Map.of(
            "philips", "off",
            "xiaomi", "off",
            "ikea", "off",
            "osram","off",
            "yeelight", "off"));

    private static final List<String> BRAND_ORDER = List.of("philips", "xiaomi", "ikea", "osram", "yeelight");
    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","專業燈具點亮","智慧燈啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉","專業燈具熄滅","智慧燈關閉");
    Map<String, Integer> brightness = new HashMap<>();

    public void controlLight(String brand, String action) {
        // 你的實作在這裡...
        // 提示：最直接的方式就是if-else判斷
        if (lightStatus.containsKey(brand)) {
            lightStatus.put(brand, action);
            int brandIndex = BRAND_ORDER.indexOf(brand);
            int msgIndex = brandIndex + (action.equals("on") ? 0 : 5);
            System.out.println(brand + msg.get(msgIndex));
        } else {
            lightStatus.put(brand, "不支援此產品");
            System.out.println("不支援的品牌:" + brand);
        }
    }
    // setBrightness(brand, level) - level 1-100

    // LightController裡再新增1種方法
    public void setBrightness(String brand, int level) {
        if (level > 0 && level < 101) {
            brightness.put(brand,level);
            System.out.println(brand + " 燈泡亮度調節至 " + level + "%");
        } else {
            System.out.println("亮度範圍錯誤: " + level + "(應介於1-100之間)");
        }
    }

    public void showAllLightStatus() {
        // 這裡先簡單示範
        System.out.println();
        System.out.println("=== 所有燈具狀態總覽 ===");
        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
            if (!entry.getValue().equals("不支援此產品")) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toUpperCase() +(brightness.get(entry.getKey()) == null ? " | 亮度: 50%" : " | 亮度: " + brightness.get(entry.getKey()) + "%"));
            }
        }

    }
}



public class Light3 {
    public static void main(String[] args) {
        LightController3 controller = new LightController3();

        // 測試用的main方法
        // 測試所有新功能
        System.out.println("\n測試案例 1: 基本開關功能");
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");
        controller.controlLight("ikea", "on");
        controller.controlLight("osram", "on");
        controller.controlLight("yeelight", "on");

        System.out.println("\n測試案例 2: 亮度調節功能");
        controller.setBrightness("philips", 80);
        controller.setBrightness("xiaomi", 90);
        controller.setBrightness("osram", 75);
        controller.setBrightness("yeelight", 85);

        System.out.println("\n測試案例 3: 錯誤輸入測試");
        controller.setBrightness("philips", 150); // 超出範圍
        controller.controlLight("unknown", "on"); // 不支援品牌

        controller.showAllLightStatus(); // 要輸出status、brightness
    }
}
