import java.util.*;
public class Main {
    public static void main(String[] args) {
        Ticket t1 = new Ticket(1000, "2018-06-30", "2025-09-27", false, false);
        System.out.println(t1.age());
        System.out.println(t1.finalPrice());
    }
}