import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> books = new ArrayList<Book>();

    public List<Book> listBooks() {
        return books;
    }
    public String newBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入新增書籍ISBN：");
        String isbn = sc.nextLine();
        System.out.print("請輸入新增書籍名稱：");
        String title = sc.nextLine();
        System.out.print("請輸入新增書籍作者：");
        String author = sc.nextLine();
        System.out.print("請輸入新增書籍出版日期：");
        String publishedAtStr = sc.nextLine();
        LocalDate publishedAt = LocalDate.parse(publishedAtStr);
        books.add(new Book(isbn,title,author,publishedAt,null,null));
        return "新增成功";
    }

    public String deleteBook() {
        return "刪除成功";
    }
}
