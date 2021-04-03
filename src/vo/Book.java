package vo;

public class Book {
    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBorrowablenumber() {
        return borrowablenumber;
    }

    public void setBorrowablenumber(int borrowable_number) {
        this.borrowablenumber = borrowable_number;
    }

    private String bookname;
    private String press;
    private String author;
    private int borrowablenumber;
}
