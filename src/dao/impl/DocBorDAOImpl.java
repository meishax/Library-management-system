package dao.impl;
import vo.*;
import dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocBorDAOImpl implements IDocBorDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public DocBorDAOImpl(Connection conn) {
        this.conn = conn;
}

    public boolean doCreateDocBor(DocBor docbor) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO documentborrowed(borrowedbookid, borrowedbookname, borrowstudentsno, borrowstudentname) VALUES (?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
    //    System.out.println(docbor.getClass());
       // System.out.println("这是doCreateDocBor(DocBor docbor)");
        this.pstmt.setString(1, docbor.getBorrowedbookid());
        this.pstmt.setString(2, docbor.getBorrowedbookname());
        this.pstmt.setString(3, docbor.getBorrowstudentsno());
        this.pstmt.setString(4, docbor.getBorrowstudentname());
        if (this.pstmt.executeUpdate() > 0) {
       //     System.out.println("执行插入");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean updateDocBor(DocBor docbor) throws Exception{
        boolean flag = false;
        String sql = "UPDATE documentborrowed SET borrowedbookname=? , borrowstudentsno=?,borrowstudentname=? WHERE borrowedbookid=?";
        this.pstmt = this.conn.prepareStatement(sql);
    //    System.out.println(docbor.getClass());
    //    System.out.println("updateStu(DocBor docbor)");
        this.pstmt.setString(1,docbor.getBorrowedbookname());
        this.pstmt.setString(2,docbor.getBorrowstudentsno());
        this.pstmt.setString(3,docbor.getBorrowstudentname());
        this.pstmt.setString(4,docbor.getBorrowedbookid());
        if (this.pstmt.executeUpdate()>0){
      //      System.out.println("执行修改");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean deleteDocBor(String borrowedbookid) throws Exception{
        boolean flag = false;
        String sql = "delete from documentborrowed where borrowedbookid = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,borrowedbookid);
        if (this.pstmt.executeUpdate()>0){
            System.out.println("执行删除");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public List<DocBor> findAllDocBor() throws Exception {
        List<DocBor> all = new ArrayList<DocBor>();
        String sql = "SELECT borrowedbookid,borrowedbookname,borrowstudentsno,borrowstudentname FROM documentborrowed";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        DocBor docbor = null;
        while (rs.next()) {
            docbor = new DocBor();
            docbor.setBorrowedbookid(rs.getString(1));
            docbor.setBorrowedbookname(rs.getString(2));
            docbor.setBorrowstudentsno(rs.getString(3));
            docbor.setBorrowstudentname(rs.getString(4));
            all.add(docbor);
        }
        this.pstmt.close();
        return all;
    }

    public List<DocBor> findByBorrowedbookid(String borrowedbookid) throws Exception{
        List<DocBor> all = new ArrayList<DocBor>() ;
        String sql = "SELECT borrowedbookid,borrowedbookname,borrowstudentsno,borrowstudentname FROM documentborrowed WHERE borrowedbookid=?" ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,borrowedbookid);
        ResultSet rs = this.pstmt.executeQuery();
        DocBor docbor = null;
        while (rs.next()) {
            docbor = new DocBor();
            docbor.setBorrowedbookid(rs.getString(1));
            docbor.setBorrowedbookname(rs.getString(2));
            docbor.setBorrowstudentsno(rs.getString(3));
            docbor.setBorrowstudentname(rs.getString(4));
            all.add(docbor);
        }
        this.pstmt.close();
        return all;
    }

    public List<DocBor> findByBorrowstudentsno(String borrowstudentsno) throws Exception{
        List<DocBor> all = new ArrayList<DocBor>() ;
        String sql = "SELECT borrowedbookid,borrowedbookname,borrowstudentsno,borrowstudentname FROM documentborrowed WHERE borrowstudentsno=?" ;
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1, borrowstudentsno);
        ResultSet rs=this.pstmt.executeQuery();
        DocBor docbor=null;
        while (rs.next()) {
            docbor = new DocBor();
            docbor.setBorrowedbookid(rs.getString(1));
            docbor.setBorrowedbookname(rs.getString(2));
            docbor.setBorrowstudentsno(rs.getString(3));
            docbor.setBorrowstudentname(rs.getString(4));
            all.add(docbor);
        }
        this.pstmt.close();
        return all;
    }




























}
