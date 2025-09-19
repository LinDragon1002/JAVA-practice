import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("歡迎使用本圖書館系統");
            String rep = "";
            switch (sc.nextInt()) {
                case 0:
                    System.out.println("exit");
                    flag = false;
                    break;
                case 1:
                    List<Book> books = lib.listBooks();
                    for (Book book : books) {
                        System.out.println(book.isbn + book.title + book.author + book.publishedAt);
                    }
                    break;
                case 2:
                    rep = lib.newBooks();
                    System.out.println(rep);
                    break;
                case 3:
                    rep = lib.deleteBook();
                    System.out.println(rep);
                    break;
                default:
                    System.out.print("error");
                    break;
            }

        }
    }
}