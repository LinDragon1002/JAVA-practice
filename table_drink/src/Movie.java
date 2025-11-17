public class Movie {
    private String name;
    private String type;
    private int price;
    private String rating; //分級
    private String time;

    public Movie(String name, String type, int price, String rating, String time) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rating = rating;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if (type.equals("恐怖片")) {
            this.rating = "R18";
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        if (time.equals("凌晨")) {
            this.price -= 20;
        }
    }

    public void getInfo() {
        System.out.printf("我看了:%s，是%s，分級為%s，在%s，價格是%d\n", name, type, rating, time, price);
    }
}
