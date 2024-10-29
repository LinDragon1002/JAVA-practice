public class Book {
    String name;
    String author;
    int ISBN;
    Boolean borrow;

    public Book(String name, String author, int ISBN,Boolean borrow){
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.borrow = borrow;
    }

    public void borrow(){

    }

    public void returnBook(){

    }

    public String toString(){
        return this.name;
    }

}
