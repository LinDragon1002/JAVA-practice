public class Main {
    public static void main(String[] args) {
        int total = 0;

        Ticket t1 = new Ticket(1000, "2018-06-30", "2025-09-27", false, false);
        int a1 = t1.age();
        int p1 = t1.finalPrice();
        System.out.println("A1 age=" + a1);
        System.out.println("A1 price=" + p1);
        total += p1;

        Ticket t2 = new Ticket(1000, "2008-04-15", "2025-09-27", true,  true);
//        int a2 = t2.age();
        int p2 = t2.finalPrice();
//        System.out.println("A2 age=" + a2);
        System.out.println("A2=" + p2);
        total += p2;

        Ticket tb = new Ticket(1200, "2021-10-01", "2025-09-27", true, true);
        int pb = tb.finalPrice();
        if (pb == 0) System.out.println("B FREE");
        else System.out.println(pb);
        total += pb;

        Ticket tc = new Ticket(1000, "1955-09-27", "2025-09-27", false, false);
        int pc = tc.finalPrice();
        System.out.println(pc);
        total += pc;

        Ticket td = new Ticket(60, "2010-09-28", "2025-09-27", true, false);
        int pd = td.finalPrice();
        System.out.println("D(min50) " + pd);
        total += pd;

        Ticket te = new Ticket(999, "2019-09-27", "2025-09-27", false, false);
        int pe = te.finalPrice();
        System.out.println("E price=" + pe);
        total += pe;

        Ticket tf = new Ticket(555, "2010-09-27", "2025-09-27", true, true);
        int pf = tf.finalPrice();
        System.out.println("F price=" + pf);
        System.out.println("F age " + tf.age());
        total += pf;

        System.out.println("TOTAL=" + total);
    }
}