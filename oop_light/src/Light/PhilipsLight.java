package Light;

public class PhilipsLight implements SmartLight {
    private boolean isOn = false;
    private int brightness = 50;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Philips智慧燈泡優雅點亮");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Philips智慧燈泡柔和熄滅");
    }

    @Override
    public void setBrightness(int level) {
        if (level >= 1 && level <= 100) {
            this.brightness = level;
            System.out.println("philips 燈泡亮度調節至 " + level + "%");
        } else {
            System.out.println("亮度範圍錯誤: " + level + " (應介於1-100之間)");
        }
    }

    @Override
    public String getBrand() {
        return "philips";
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public int getBrightness() {
        return brightness;
    }
}
