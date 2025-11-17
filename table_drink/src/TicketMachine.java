public interface TicketMachine {
    // 取得電影名稱陣列
    String[] getMoviesName();

    String buyTicket(String name,int payment);

    String buyTicket(String name,String cardType);
}