package vo;

public class Stu {
    private String sno;
    private String sname;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public int getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(int borrownumber) {
        this.borrownumber = borrownumber;
    }

    private String sclass;
    private String smajor;
    private int borrownumber;
}
