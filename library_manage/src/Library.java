import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library implements Manage{
    List<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public List<Book> addBook(){
        books.add(new Book("who","me",123456789,false));
        books.add(new Book("wolf","you",987654321,false));
        books.add(new Book("apple","brother",456789123,true));
        books.add(new Book("banana","mother",741852963,true));
        return books;
    }

    @Override
    public void borrowBook(int book){
        if (book >= books.size()){
            System.out.println(books.get(book-books.size()-1).name + "被借走了");
        }else {
            books.get(book).borrow = true;
            System.out.println("成功借閱" + books.get(book).name);
        }
    }

    @Override
    public void returnBook(int book){
        if (book <= books.size()){
            System.out.println("沒有借閱" + books.get(book-books.size()-1).name);
        }else {
            books.get(book-books.size()-1).borrow = false;
            System.out.println("已歸還" + books.get(book-books.size()-1).name);
        }
    }

    @Override
    public int checkBook(String book){
        int run = 0;
        for (int i=0;i < books.size();i++){
            if (books.get(i).name.equals(book)){
                if (books.get(i).borrow.equals(false)){
                    return i;
                }else{
                    return books.size()+1+i;
                }
            }else{
                run++;
            }
        }
        if (run >= books.size()){
            return books.size()*2+2;
        }
        return books.size()+3;
    }

    @Override
    public String runBook(String choose){
        String book = "";
        if (choose.equals("A")){
            System.out.print("請輸入想借書名：");
            String getBook = sc.nextLine();
            int checkAnswer = checkBook(getBook);
            borrowBook(checkAnswer);
            book = getBook;

        }else if (choose.equals("B")){
            System.out.print("請輸入歸還書名：");
            String getBook = sc.nextLine();
            int checkAnswer = checkBook(getBook);
            returnBook(checkAnswer);
            book = getBook;

        }else if (choose.equals("C")){
            String getBook = sc.nextLine();
            int checkAnswer = checkBook(getBook);
            if (checkAnswer <= books.size()){
                System.out.println(getBook + "沒有被借走了");
            }else if (checkAnswer >= books.size()+1 || checkAnswer <= books.size()*2+1){
                System.out.println(getBook + "被借走了");
            }else if (checkAnswer >= books.size()*2+2){
                System.out.println("找不到這本書");
            }
            System.out.println();
        }
        return book;
    }

    @Override
    public void addBook(String book){
        System.out.println("are");
    }
}
