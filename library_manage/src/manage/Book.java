//包裝到manage資料夾
package manage;

//書本的基本資料：書名、作者、ISBN、是否被借閱
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

    //回傳書名
    public String toString(){
        return this.name;
    }

}
