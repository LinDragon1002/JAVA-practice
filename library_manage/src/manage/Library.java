//包裝到manage資料夾
package manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements ManageInterface {
    public List<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //管理圖書館書籍
    @Override
    public List<Book> allBook() {
        books.add(new Book("who", "me", 123456789, false));
        books.add(new Book("wolf", "you", 987654321, false));
        books.add(new Book("apple", "brother", 456789123, true));
        books.add(new Book("banana", "mother", 741852963, true));
        return books;
    }

    //借書
    @Override
    public void borrowBook(String book) {
        for (Book book1 : books){
            if (book1.name.equals(book)){
                if (book1.borrow.equals(false)){
                    book1.borrow = true;
                    System.out.println("成功借閱" + book1.name);
                }else{
                    System.out.println(book1.name + "被借走了");
                }
            }
        }
    }

    //還書
    @Override
    public void returnBook(String book) {
        for (Book book1 : books){
            if (book1.name.equals(book)){
                if (book1.borrow.equals(true)) {
                    book1.borrow = false;
                    System.out.println("已歸還" + book1.name);
                }else{
                    System.out.println("沒有借閱" + book1.name);
                }
            }
        }
    }

    //輸入的書籍名稱
    @Override
    public String inputBook() {
        return sc.nextLine();
    }

    //判斷是要借書、還書還是查詢書本
    @Override
    public void runBook(String choose) {
        switch (choose.toUpperCase()) {
            case "A":
                System.out.print("請輸入想借書名：");
                borrowBook(inputBook());
                break;
            case "B":
                System.out.print("請輸入歸還書名：");
                returnBook(inputBook());
                break;
            case "C":
                System.out.print("請輸入查詢書名：");
                String book = sc.nextLine();
                checkBook(book);
                break;
        }
        System.out.println();
    }

    //檢查是否有這本書籍
    @Override
    public void checkBook(String book) {
        int run = 0;
        for (Book book1 : books){
            if (book1.name.equals(book)){
                if (book1.borrow.equals(false)) {
                    System.out.println(book1.name + "沒有被借走");
                }else{
                    System.out.println(book1.name + "被借走");
                }
            }else {
                run++;
            }
        }

        if (run >= books.size()){
            System.out.println("沒有" + book + "這本書");
        }
    }

    //判斷新增、刪除或是查詢書籍
    @Override
    public void addBook(int choose) {
        switch (choose) {
            case 0:
                addNewBook();
                break;
            case 1:
                removeBook();
                break;
            case 2:
                String book = sc.nextLine();
                checkBook(book);
                break;
        }
    }

    //新增書籍
    private void addNewBook() {
        System.out.print("請輸入新增書籍名稱：");
        String name = sc.nextLine();
        System.out.print("請輸入新增書籍作者：");
        String author = sc.nextLine();
        System.out.print("請輸入新增書籍ISBN：");
        int ISBN = Integer.parseInt(sc.nextLine());
        books.add(new Book(name, author, ISBN, false));
        System.out.println("成功新增" + name);
    }

    //刪除書籍
    private void removeBook() {
        System.out.print("請輸入刪除書籍名稱：");
        String name = sc.nextLine();

        Book bookToRemove = null;
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(name)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("成功刪除書籍：" + name);
        } else {
            System.out.println("未找到書籍：" + name);
        }
    }
}
