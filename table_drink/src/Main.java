import java.util.*;
public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("鈴芽之旅", "喜劇片", 250, "普通級", "晚上");
        Movie movie2 = new Movie("霍爾的移動城堡", "喜劇片", 250, "普通級", "晚上");
        Movie movie3 = new Movie("灌籃高手 THE FIRST SLAM DUNK", "喜劇片", 250, "普通級", "晚上");
        Movie[] movies = {movie1, movie2, movie3};

        TicketMachine oldMachine = new CashOnlyMachine(movies);
        System.out.println(Arrays.toString(oldMachine.getMoviesName()));
        System.out.println(oldMachine.buyTicket("鈴芽之旅",100));
        System.out.println(oldMachine.buyTicket("霍爾的移動城堡",250));
        System.out.println(oldMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK",300));
        System.out.println(oldMachine.buyTicket("鈴芽之旅","信用卡"));


        TicketMachine newMachine = new CashMachine(movies);
        System.out.println(Arrays.toString(newMachine.getMoviesName()));
        System.out.println(newMachine.buyTicket("鈴芽之旅",100));
        System.out.println(newMachine.buyTicket("霍爾的移動城堡",250));
        System.out.println(newMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK",300));
        System.out.println(newMachine.buyTicket("灌籃高手 THE FIRST SLAM DUNK","信用卡"));

    }
}