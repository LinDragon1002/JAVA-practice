import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 給學生的起始框架
class LightController {
    // TODO: 實作controlLight方法
    // 需求：根據brand參數控制不同品牌的燈
    // brand可能的值："philips", "xiaomi", "ikea"
    // action可能的值："on", "off"
    List<String> brands = List.of("philips", "xiaomi", "ikea");
    List<List<String>> allLight = new ArrayList<>();
    List<String> temps = new ArrayList<>();

    public void controlLight(String brand, String action) {
        try {
            temps.add(brand);
            // 直接檢查品牌是否存在
            if (!brands.contains(brand)) {
                throw new IllegalArgumentException();
            }

            if (action.equals("on")) {
                temps.add("開燈");
            } else if (action.equals("off")) {
                temps.add("關燈");
            }
            allLight.add(new ArrayList<>(temps));
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
            System.out.println(light.get(0) + ":" + light.get(1));
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