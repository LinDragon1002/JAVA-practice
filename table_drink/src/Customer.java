import java.time.LocalDate;
import java.time.DayOfWeek;

public class Customer {
    private String name;
    private String date;
    private int person;

    // 建構元
    public Customer(String name, String date, int person) {
        this.name = name;
        this.date = date;
        this.person = person;
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    // 計算用餐價格
    public int price() {
        // 判斷是否為假日（星期六或星期日）
        LocalDate dateObj = LocalDate.parse(date);
        DayOfWeek dayOfWeek = dateObj.getDayOfWeek();
        boolean isHoliday = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);

        // 基本費用
        int basePrice;
        if (isHoliday) {
            basePrice = person * 1200;
        } else {
            basePrice = person * 900;
        }

        // 團體折扣（只有偶數人數才有折扣）
        int discount = 0;
        if (person % 2 == 0) {
            discount = person * 150;
        }

        // 計算總價
        int total = basePrice - discount;

        // 最低價格限制
        int minPrice = person * 500;
        if (total < minPrice) {
            total = minPrice;
        }

        return total;
    }
}