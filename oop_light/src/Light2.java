import java.awt.*;
import java.util.*;
import java.util.List;

// 給學生的起始框架
//class LightController2 {
//    List<String> brands = List.of("philips", "xiaomi", "ikea");
//    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉");
//    List<List<String>> allLight = new ArrayList<>();
//    List<String> temps = new ArrayList<>();
//
//    public void controlLight(String brand, String action) {
//        try {
//            temps.add(brand);
//            // 直接檢查品牌是否存在
//            if (!brands.contains(brand)) {
//                throw new IllegalArgumentException();
//            }
//
//            int exitingBrand = 0;
//            for (List<String> light : allLight) {
//                if (light.get(0).equals(brand)) {
//                    if (action.equals("on")) {
//                        light.set(1, "開燈");
//                        light.set(2, msg.get(brands.indexOf(brand)));
//                    } else if (action.equals("off")) {
//                        light.set(1, "關燈");
//                        light.set(2, msg.get(brands.indexOf(brand) + brands.size()));
//                    }
//                    exitingBrand = 1;
//                    break;
//                }
//            }
//            if (exitingBrand == 0) {
//                if (action.equals("on")) {
//                    temps.add("開燈");
//                    temps.add(msg.get(brands.indexOf(brand)));
//                } else if (action.equals("off")) {
//                    temps.add("關燈");
//                    temps.add(msg.get(brands.indexOf(brand)+brands.size()));
//                }
//                allLight.add(new ArrayList<>(temps));
//            }
//
//            temps.clear();
//
//        } catch (Exception e) {
//            temps.add("不支援此產品");
//            allLight.add(new ArrayList<>(temps));
//            temps.clear();
//        }
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
//            allLight.add(new ArrayList<>(Arrays.asList(brand, "不支援此產品")));
//            temps.clear();
//        }
//    }
//
//    public void showAllLightStatus() {
//        // 提示：顯示所有燈具的狀態總覽
//        for (List<String> light : allLight) {
//            String brand = light.get(0);
//            String action = light.get(1);
//            String message = light.size() >= 2 ? light.get(2) : "";
//
//            System.out.println("當" + brand + action + "輸出:" + brand + message);
//        }
//    }
//}

class LightController2 {
    // 需求：根據brand參數控制不同品牌的燈
    // brand可能的值："philips", "xiaomi", "ikea"
    // action可能的值："on", "off"

    private Map<String, String> lightStatus = new HashMap<>(Map.of(
            "philips", "off",
            "xiaomi", "off",
            "ikea", "off"));

    List<String> msg =  List.of("智慧燈泡優雅點亮","燈泡瞬間點亮","燈具溫馨啟動","智慧燈泡柔和熄滅","燈泡立即關閉","燈具安靜關閉");

    public void controlLight(String brand, String action) {
        // 你的實作在這裡...
        // 提示：最直接的方式就是if-else判斷
        List<String> brandList = new ArrayList<>(lightStatus.keySet());

        if (lightStatus.containsKey(brand)) {
            lightStatus.put(brand, action);
            int brandIndex = brandList.indexOf(brand);
            int msgIndex = brandIndex + (action.equals("on") ? 0 : 3);
            System.out.println(brand + msg.get(msgIndex));
        } else {
            lightStatus.put(brand, "不支援此產品");
            System.out.println("不支援的品牌: " + brand);
        }

    }

    public void showAllLightStatus() {
        // 這裡先簡單示範
        List<String> brandList = new ArrayList<>(lightStatus.keySet());

//        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
//            String brand = entry.getKey();
//            String status = entry.getValue();
//
//            if (status.equals("不支援此產品")) {
//                System.out.println("不支援的品牌:" + brand);
//            } else {
//                int brandIndex = brandList.indexOf(brand);
//                int msgIndex = brandIndex + (status.equals("on") ? 0 : 3);
//                System.out.println(brand + msg.get(msgIndex));
//            }
//        }
        System.out.println("=== 所有燈具狀態總覽 ===");
        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
            if (!entry.getValue().equals("不支援此產品")) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toUpperCase());
            }

        }

    }
}


public class Light2 {
    public static void main(String[] args) {
        LightController2 controller = new LightController2();

        controller.controlLight("philips", "on");
        controller.controlLight("xiaomi", "on");
        controller.controlLight("ikea", "on");
        controller.showAllLightStatus();

        controller.controlLight("xiaomi", "off");
        controller.controlLight("philips", "off");
        controller.controlLight("ikea", "off");
        controller.showAllLightStatus();
    }
}
