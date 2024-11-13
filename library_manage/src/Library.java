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

    @Override
    public void borrowBook(int book) {
        if (book >= books.size()) {
            System.out.println(books.get(book - books.size() - 1).name + "被借走了");
        } else {
            books.get(book).borrow = true;
            System.out.println("成功借閱" + books.get(book).name);
        }
    }

    @Override
    public void returnBook(int book) {
        if (book <= books.size()) {
            System.out.println("沒有借閱" + books.get(book - books.size() - 1).name);
        } else {
            books.get(book - books.size() - 1).borrow = false;
            System.out.println("已歸還" + books.get(book - books.size() - 1).name);
        }
    }

    @Override
    public int checkBook(String book) {
        int run = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).name.equals(book)) {
                if (books.get(i).borrow.equals(false)) {
                    return i;
                } else {
                    return books.size() + 1 + i;
                }
            } else {
                run++;
            }
        }
        if (run >= books.size()) {
            return books.size() * 2 + 2;
        }
        return books.size() + 3;
    }

    @Override
    public int inputBook() {
        String getBook = sc.nextLine();
        return checkBook(getBook);
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
                String getBook = sc.nextLine();
                printCheckBookResult(getBook);
                break;
        }
        System.out.println();
    }

    private void printCheckBookResult(String book) {
        int checkAnswer = checkBook(book);
        if (checkAnswer <= books.size()) {
            System.out.println(book + "沒有被借走了");
        } else if (checkAnswer >= books.size() + 1 || checkAnswer <= books.size() * 2 + 1) {
            System.out.println(book + "被借走了");
        } else if (checkAnswer >= books.size() * 2 + 2) {
            System.out.println("找不到這本書");
        }
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
                printCheckBookResult(book);
                break;
        }
    }

    private void addNewBook() {
        System.out.print("請輸入新增書籍名稱：");
        String name = sc.nextLine();
        System.out.print("請輸入新增書籍作者：");
        String author = sc.nextLine();
        System.out.print("請輸入新增書籍ISBN：");
        int ISBN = sc.nextInt();
        books.add(new Book(name, author, ISBN, false));
        System.out.println("成功新增" + name);
    }

    private void removeBook() {
        System.out.print("請輸入刪除書籍名稱：");
        String name = sc.nextLine();
        books.remove(name);
        System.out.println("成功刪除" + name);
    }
}
