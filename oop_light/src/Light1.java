import java.util.ArrayList;
import java.util.List;

// 給學生的起始框架
class LightController {
    // TODO: 實作controlLight方法
    // 需求：根據brand參數控制不同品牌的燈
    // brand可能的值："philips", "xiaomi", "ikea"
    // action可能的值："on", "off"
    String[] brands = {"philips", "xiaomi", "ikea"};
    String[] actions = {"on", "off"};
    List<String> allLightStatus = new ArrayList<>();

    public void controlLight(String brand, String action) {
        // 你的實作在這裡...
        // 提示：最直接的方式就是if-else判斷
        for (String brandLight : brands) {
            if (brandLight.equals(brand)) {
                if (action.equals(actions[0])) {
                    allLightStatus.add(brand + " " + action);
                } else if (action.equals(actions[1])) {
                    allLightStatus.add(brand + " " + action);
                }
            }
        }

    }

    public void showAllLightStatus() {
        // 提示：顯示所有燈具的狀態總覽
        for (String lightStatus : allLightStatus) {
            System.out.println(lightStatus);
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