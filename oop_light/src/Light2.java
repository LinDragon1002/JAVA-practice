import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 給學生的起始框架
class LightController2 {
    String brands = "philips,xiaomi,ikea";
    String msg = "智慧燈泡優雅點亮,燈泡瞬間點亮,燈具溫馨啟動,智慧燈泡柔和熄滅,燈泡立即關閉,燈具安靜關閉";
    Map<String,Boolean> allLightStatus = new HashMap<>();

    public void controlLight(String brand, String action) {
        for (String brandLight : brands.split(",")) {
            if (brandLight.equals(brand)) {
                if (action.equals("on")) {
                    allLightStatus.put(brand,true);
                } else if (action.equals("off")) {
                    allLightStatus.put(brand,false);
                }
            }
        }
    }

    public void showAllLightStatus() {
        // 提示：顯示所有燈具的狀態總覽
        for (Map.Entry<String, Boolean> entry : allLightStatus.entrySet()) {
            String status = entry.getValue() ? "開燈" : "關燈";
//            String message = msg.indexOf(brands.indexOf(entry.getKey()));
//            msg.indexOf()
            System.out.println(entry.getKey() + status + "輸出:" + entry.getKey() + "");
        }
        allLightStatus.clear();
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
