import java.time.LocalDate;
import java.time.DayOfWeek;

public class VIPCustomer extends Customer {
    private String wine;

    // 建構元
    public VIPCustomer(String name, String date, int person, String wine) {
        super(name, date, person);
        this.wine = wine;
    }

    // Getter 和 Setter
    public String getWine() {
        return wine;
    }

    public void setWine(String wine) {
        this.wine = wine;
    }

    // 覆寫計算用餐價格
    @Override
    public int price() {
        // 判斷是否為假日
        LocalDate dateObj = LocalDate.parse(getDate());
        DayOfWeek dayOfWeek = dateObj.getDayOfWeek();
        boolean isHoliday = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);

        // 基本費用
        int basePrice;
        if (isHoliday) {
            basePrice = getPerson() * 1200;
        } else {
            basePrice = getPerson() * 900;
        }

        // VIP團體折扣（無論單雙數都有折扣）
        int discount = getPerson() * 150;

        // 計算用餐總價
        int total = basePrice - discount;

        // 最低價格限制
        int minPrice = getPerson() * 500;
        if (total < minPrice) {
            total = minPrice;
        }

        // 計算紅酒費用
        int wineBottles = (int) Math.ceil(getPerson() / 2.0);
        int winePrice;
        if (wine.equals("A") || wine.equals("C") || wine.equals("Z")) {
            winePrice = wineBottles * 550;
        } else {
            winePrice = wineBottles * 400;
        }

        // VIP假日特殊折扣（假日且人數≥6）
        if (isHoliday && getPerson() >= 6) {
            winePrice = (int) (winePrice * 0.8);
        }

        return total + winePrice;
    }
}
