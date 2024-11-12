import java.util.*;
interface Manage {
    List<Book> addBook();
    void borrowBook(int book);
    void returnBook(int book);
    String runBook(String choose);
    int checkBook(String book);
    void addBook(String book);
}
