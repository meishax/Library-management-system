package vo;

public class DocBor {


    private String borrowedbookid;

    public String getBorrowedbookid() {
        return borrowedbookid;
    }

    public void setBorrowedbookid(String borrowedbookid) {
        this.borrowedbookid = borrowedbookid;
    }

    public String getBorrowedbookname() {
        return borrowedbookname;
    }

    public void setBorrowedbookname(String borrowedbookname) {
        this.borrowedbookname = borrowedbookname;
    }

    public String getBorrowstudentsno() {
        return borrowstudentsno;
    }

    public void setBorrowstudentsno(String borrowstudent_sno) {
        this.borrowstudentsno = borrowstudent_sno;
    }

    public String getBorrowstudentname() {
        return borrowstudentname;
    }

    public void setBorrowstudentname(String borrowstudent_name) {
        this.borrowstudentname = borrowstudent_name;
    }

    private String borrowedbookname;
    private String borrowstudentsno;
    private String borrowstudentname;
}
