//import java.util.*;
//
//// 給學生的起始框架
//class LightController {
//    // TODO: 實作controlLight方法
//    // 需求：根據brand參數控制不同品牌的燈
//    // brand可能的值："philips", "xiaomi", "ikea"
//    // action可能的值："on", "off"
//    List<String> brands = List.of("philips", "xiaomi", "ikea");
//    List<List<String>> allLight = new ArrayList<>();
//    List<String> temps = new ArrayList<>();
//
//    public void controlLight(String brand, String action) {
//        try {
//            // 直接檢查品牌是否存在
//            if (!brands.contains(brand)) {
//                throw new IllegalArgumentException();
//            }
//            String status = action.equals("on") ? "開燈" : "關燈";
//            allLight.add(new ArrayList<>(Arrays.asList(brand, status)));
//            temps.clear();
//        } catch (Exception e) {
//            allLight.add(new ArrayList<>(Arrays.asList(brand, "不支援此產品")));
//            temps.clear();
//        }
//    }
//
//    public void showAllLightStatus() {
//        // 提示：顯示所有燈具的狀態總覽
//        for (List<String> light : allLight) {
//            System.out.println(light.get(0) + ":" + light.get(1));
//        }
//    }
//}
//
//// 測試用的main方法
//public class Light1 {
//    public static void main(String[] args) {
//        LightController controller = new LightController();
//
//        // 測試案例
//        controller.controlLight("philips", "on");
//        controller.controlLight("xiaomi", "off");
//        controller.controlLight("ikea", "on");
//        controller.controlLight("unknown", "on"); // 如果出現不支援品牌 要如何應變呢?
//        controller.showAllLightStatus();
//    }
//}
// 給學生的起始框架

import java.util.*;

class LightController {
    // 需求：根據brand參數控制不同品牌的燈
    // brand可能的值："philips", "xiaomi", "ikea"
    // action可能的值："on", "off"

    private Map<String, String> lightStatus = new HashMap<>(Map.of(
            "philips", "off",
            "xiaomi", "off",
            "ikea", "off"));

    public void controlLight(String brand, String action) {
        // 你的實作在這裡...
        // 提示：最直接的方式就是if-else判斷
        if (lightStatus.containsKey(brand)) {
            lightStatus.put(brand, action);
        } else {
            lightStatus.put(brand, "不支援此產品");
        }
    }

    public void showAllLightStatus() {
        // 這裡先簡單示範
        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
            if (entry.getValue().equals("不支援此產品")) {
                System.out.println("不支援的品牌:"+entry.getKey());
            }else {
                System.out.println("已將 " + entry.getKey() + " 燈設為 " + entry.getValue().toUpperCase());
            }

        }
        System.out.println("=== 所有燈具狀態總覽 ===");
        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
            if (!entry.getValue().equals("不支援此產品")) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toUpperCase());
            }

        }

    }
}

// 測試用的main方法
public class Light1 {
    public static void main(String[] args) {
        LightController controller = new LightController();

        // 測試案例
        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "off");
        controller.controlLight("ikea", "on");
        controller.controlLight("unknown", "on"); // 如果出現不支援品牌 要如何應變呢?
        controller.showAllLightStatus();
    }
}