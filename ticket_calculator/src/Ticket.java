import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class Ticket {
    private int base;
    private String birth;
    private String visit;
    private boolean student;
    private boolean holiday;

    Ticket(int base, String birth, String visit, boolean student, boolean holiday) {
        this.base = base;
        this.birth = birth;
        this.visit = visit;
        this.student = student;
        this.holiday = holiday;
    }
    public int age() {
        LocalDate visitDate = LocalDate.parse(visit);
        LocalDate birthDate = LocalDate.parse(birth);
        Period cal_age = Period.between(birthDate, visitDate);
        return cal_age.getYears();
    }
    public int finalPrice() {
        double finalPrice = base;
        LocalDate visitDate = LocalDate.parse(visit);
        LocalDate birthDate = LocalDate.parse(birth);
        Period cal_age = Period.between(birthDate, visitDate);
        int age = cal_age.getYears();
        if (age < 6) {
            return 0;
        } else if (age >= 6 && age <= 11) {
            finalPrice = base * 0.5;
        } else if (age >= 13 && age <= 17) {
            finalPrice = base * 0.8;
        } else if (age >= 65) {
            finalPrice = base * 0.7;
        }
        if (this.student) {
            finalPrice = finalPrice * 0.9;
        }
        if (this.holiday) {
            finalPrice = finalPrice * 1.1;
        }
        if (finalPrice < 50) {
            return 50;
        }
        BigDecimal bd = new BigDecimal(finalPrice);
        bd = bd.setScale(0, RoundingMode.HALF_UP);
        return bd.intValue();
    }
}
