public class CashMachine extends CashOnlyMachine {
    private Movie[] movies;
    private int price;

    // 建構元：接收 Movie 陣列並傳給父類
    public CashMachine(Movie[] movies) {
        super(movies);
        this.movies = movies;
    }

    // 覆寫：用卡片購買電影票
    @Override
    public String buyTicket(String name,String cardType) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().equals(name)) {
                price = movies[i].getPrice();
                break;
            }
        }
        return "購買成功!你本次消費金額為" + price + "，請領回您的信用卡";
    }
}