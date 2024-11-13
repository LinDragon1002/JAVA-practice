import java.util.*;
interface Manage {
    List<Book> allBook();
    void borrowBook(String book);
    void returnBook(String book);
    void runBook(String choose);
//    int checkBook(String book);
    void addBook(int book);
    String inputBook();
}
