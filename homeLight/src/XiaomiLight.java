public class XiaomiLight implements SmartLight {
    private boolean isOn = false;
    private int brightness = 50;
    private int temperature;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("小米燈泡瞬間點亮");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("小米燈泡立即關閉");
    }

    @Override
    public void setBrightness(int level) {
        if (level >= 1 && level <= 100) {
            this.brightness = level;
            System.out.println("xiaomi 燈泡亮度調節至 " + level + "%");
        } else {
            System.out.println("亮度範圍錯誤: " + level + " (應介於1-100之間)");
        }
    }

    @Override
    public String getBrand() {
        return "xiaomi";
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public void setColorTemperature(int temperature) {
        if (temperature >= 2700 && temperature <= 6500) {
            this.temperature = temperature;
            System.out.println("xiaomi 燈泡色溫調節至" + temperature + "K");
        } else {
            System.out.println("色溫範圍錯誤: " + temperature + "(應介於2700~6500k之間)");
        }
    }
}
