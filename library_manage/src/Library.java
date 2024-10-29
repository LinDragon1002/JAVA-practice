import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library implements Manage{
    List<Book> books = new ArrayList<>();

    @Override
    public List<Book> addBook(){
        books.add(new Book("who","me",123456789,false));
        books.add(new Book("wolf","you",987654321,false));
        books.add(new Book("apple","brother",456789123,true));
        books.add(new Book("banana","mother",741852963,true));
        return books;
    }

    @Override
    public void borrowBook(String book){
        int run = 0;
        for (int i=0;i < books.size();i++){
            if (books.get(i).name.equals(book)){
                if (books.get(i).borrow.equals(false)){
                    System.out.println("找到" + books.get(i).name);
                }else{
                    System.out.println(books.get(i).name + "被借走了");
                }
            }else{
                run++;
            }
        }
        if (run >= books.size()){
            System.out.println("找不到這本書");
        }

    }
//    @Override
//    public void returnBook(String book){
//        int run = 0;
//        for (int i=0;i <books.size();i++){
//            if (books.get(i).name.equals(book)){
//                if (books.get(i).borrow.equals(false)){
//                    System.out.println("找到" + books.get(i).name);
//                }else{
//                    System.out.println(books.get(i).name + "被借走了");
//                }
//            }else{
//                run++;
//            }
//        }
//        if (run >= books.size()){
//            System.out.println("找不到這本書");
//        }
//    }

    @Override
    public void runbook(String choose){
        Scanner sc = new Scanner(System.in);
        if (choose.equals("A")){
            System.out.print("請輸入書名：");
            String getBook = sc.nextLine();
            borrowBook(getBook);

        }else if (choose.equals("B")){
            System.out.println();
        }else if (choose.equals("C")){

            System.out.print("請輸入要找尋書名：");
            String getBook = sc.nextLine();
            borrowBook(getBook);
//            returnBook(getBook);
            System.out.println();
        }

    }
}
