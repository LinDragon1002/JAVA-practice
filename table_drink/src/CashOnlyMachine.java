public class CashOnlyMachine implements TicketMachine {
    private Movie[] movies;
    private int price;

    // 建構元：接收 Movie 陣列作為參數
    public CashOnlyMachine(Movie[] movies) {
        this.movies = movies;
    }

    // 實作：取得電影名稱陣列（從傳入的 Movie 物件中取得）
    @Override
    public String[] getMoviesName() {
        String[] movieNames = new String[movies.length];
        for (int i = 0; i < movies.length; i++) {
            movieNames[i] = movies[i].getName();
        }
        return movieNames;
    }

    // 實作：用現金購買電影票
    @Override
    public String buyTicket(String name,int payment) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().equals(name)) {
                price = movies[i].getPrice();
                break;
            }
        }
        if (payment < price) {
            return "購買失敗!金額不足，您應付" + price + "元";
        } else if (payment == price) {
            return "購買完成!祝您有美好的一天";
        } else {
            int change = payment - price;
            return "購買完成!找您" + change + "元";
        }
    }

    // 實作：用卡片購買（現金售票機不支援）
    @Override
    public String buyTicket(String name,String cardType) {
        return "購買失敗!本機器無法使用信用卡結帳";
    }
}