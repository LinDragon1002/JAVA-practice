import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library implements Manage {
    List<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public List<Book> allBook() {
        books.add(new Book("who", "me", 123456789, false));
        books.add(new Book("wolf", "you", 987654321, false));
        books.add(new Book("apple", "brother", 456789123, true));
        books.add(new Book("banana", "mother", 741852963, true));
        return books;
    }

//    private String printCheckBookResult(String book) {
//        boolean checkBook = false;
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).name.equals(book)) {
//                if (books.get(i).borrow.equals(false)) {
//                    return "沒有被借走了";
//                }else{
//                    return "被借走了";
//                }
//            }else{
//                checkBook = true;
//            }
//        }
//        if (checkBook){
//            return "找不到這本書";
//        }else{
//
//        }
//        return "";
//        int checkAnswer = checkBook(book);
//        if (checkAnswer <= books.size()) {
//            System.out.println(book + "沒有被借走了");
//        } else if (checkAnswer >= books.size() + 1 || checkAnswer <= books.size() * 2 + 1) {
//            System.out.println(book + "被借走了");
//        } else if (checkAnswer >= books.size() * 2 + 2) {
//            System.out.println("找不到這本書");
//        }
//    }

    @Override
    public void borrowBook(String book) {
        int run = 0;
        for (Book book1 : books){
            if (book1.name.equals(book)){
                book1.borrow = true;
                System.out.println("成功借閱" + book1.name);
                break;
            }else{
                run++;
            }
        }
        if (run > 0){
            System.out.println(book + "被借走了");
        }
//        if (book >= books.size()) {
//            System.out.println(books.get(book - books.size() - 1).name + "被借走了");
//        } else {
//            books.get(book).borrow = true;
//            System.out.println("成功借閱" + books.get(book).name);
//        }
    }

    @Override
    public void returnBook(String book) {
        for (Book book1 : books){
            if (book1.name.equals(book)){
                book1.borrow = false;
                System.out.println("已歸還" + book1.name);
            }else{
                System.out.println("沒有借閱" + book1.name);
            }
        }
//        if (book <= books.size()) {
//            System.out.println("沒有借閱" + books.get(book - books.size() - 1).name);
//        } else {
//            books.get(book - books.size() - 1).borrow = false;
//            System.out.println("已歸還" + books.get(book - books.size() - 1).name);
//        }
    }

    @Override
    public String inputBook() {
//        String getBook = sc.nextLine();
//        return printCheckBookResult(getBook);
        return sc.nextLine();
    }

    @Override
    public void runBook(String choose) {
        switch (choose) {
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
//                printCheckBookResult(book);
                break;
        }
        System.out.println();
    }



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
//                printCheckBookResult(book);
                break;
        }
    }

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

//    @Override
//    public int checkBook(String book) {
//        int run = 0;
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).name.equals(book)) {
//                if (books.get(i).borrow.equals(false)) {
//                    return i;
//                } else {
//                    return books.size() + 1 + i;
//                }
//            } else {
//                run++;
//            }
//        }
//        if (run >= books.size()) {
//            return books.size() * 2 + 2;
//        }
//        return books.size() + 3;
//    }

}
