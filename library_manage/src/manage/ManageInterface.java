//包裝到manage資料夾
package manage;

import java.util.*;
interface ManageInterface {
    //管理圖書館書籍
    List<Book> allBook();
    //借書
    void borrowBook(String book);
    //還書
    void returnBook(String book);
    //輸入的書籍名稱
    String inputBook();
    //判斷是要借書、還書還是查詢書本
    void runBook(String choose);
    //檢查是否有這本書籍
    void checkBook(String book);
    //新增書籍
    void addBook(int book);
}
