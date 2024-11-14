package manage;

import java.util.*;
interface ManageInterface {
    List<Book> allBook();
    void borrowBook(String book);
    void returnBook(String book);
    void runBook(String choose);
    void checkBook(String book);
    void addBook(int book);
    String inputBook();
}
