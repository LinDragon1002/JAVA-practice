import java.util.*;
interface Manage {
    List<Book> addBook();
    void borrowBook(int book);
    void returnBook(int book);
    String runbook(String choose);
    int checkBook(String book);
}
