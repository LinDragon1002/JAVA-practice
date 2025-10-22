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
        String[] visitParts = visit.split("-");
        String[] birthParts = birth.split("-");
        
        int visitYear = Integer.parseInt(visitParts[0]);
        int visitMonth = Integer.parseInt(visitParts[1]);
        int visitDay = Integer.parseInt(visitParts[2]);
        
        int birthYear = Integer.parseInt(birthParts[0]);
        int birthMonth = Integer.parseInt(birthParts[1]);
        int birthDay = Integer.parseInt(birthParts[2]);
        
        int age = visitYear - birthYear;
        
        if (visitMonth < birthMonth || 
            (visitMonth == birthMonth && visitDay < birthDay)) {
            age--;
        }
        
        return age;
    }
    
    
    public int finalPrice() {
        double finalPrice = base;
        int age = age();
        
        // 年齡折扣
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
        
        return (int) Math.round(finalPrice);
    }
}