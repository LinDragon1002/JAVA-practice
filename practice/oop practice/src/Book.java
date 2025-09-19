//包裝到manage資料夾

import java.time.LocalDate;
import java.util.Date;

//書本的基本資料：書名、作者、ISBN、是否被借閱
public class Book {
    String isbn;
    String title;
    String author;
    LocalDate publishedAt;
    Date borrowedAt;
    Date returnedAt;

    public Book(String isbn, String title, String author, LocalDate publishedAt, Date borrowedAt,Date returnedAt){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedAt = publishedAt;
        this.borrowedAt = borrowedAt;
        this.returnedAt = returnedAt;
    }

    public boolean isAvailable(){
        return false;
    }

    public Date borrow(){
        return null;
    }

    public Date returnBook(){
        return null;
    }
}
