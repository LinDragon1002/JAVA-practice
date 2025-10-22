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
    }

    public void showAllLightStatus() {
        // 這裡先簡單示範
        System.out.println("=== 所有燈具狀態總覽 ===");
        for (Map.Entry<String, String> entry : lightStatus.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toUpperCase());
        }

    }
}

// 測試用的main方法
public class App {
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


// setBrightness(brand, level) - level 1-100

// LightController裡再新增1種方法
public void setBrightness(String brand, int level) {
    // ??
}


public class DeviceController {
    public void controlDevice(String type, String brand, String action) {
        if (type.equals("light")) {
            // 40 行的燈具邏輯
        } else if (type.equals("fan")) {
            // 又要寫一堆 if-else
        } else if (type.equals("speaker")) {
            // 再寫一堆 if-else
        }
    }
    
    public void adjustDevice(String type, String brand, String param, int value) {
        // 這個方法要處理：亮度、色溫、轉速、音量...
        // if (type + brand + param) 的排列組合...
    }
}

