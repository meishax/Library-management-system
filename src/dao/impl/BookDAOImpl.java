package dao.impl;

import vo.*;
import dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public BookDAOImpl(Connection conn) {
        this.conn = conn;

    }

    public boolean doCreateBook(Book book) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO book(ISBN, bookname, press, author, borrowablenumber) VALUES (?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        //System.out.println(book.getClass());
        //System.out.println("这是doCreateBook(Book book)");
        this.pstmt.setString(1, book.getISBN());
        this.pstmt.setString(2, book.getBookname());
        this.pstmt.setString(3, book.getPress());
        this.pstmt.setString(4, book.getAuthor());
        this.pstmt.setInt(5, book.getBorrowablenumber());
        if (this.pstmt.executeUpdate() > 0) {
           // System.out.println("执行插入");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public List<Book> findAllBook() throws Exception {
        List<Book> all = new ArrayList<Book>();
        String sql = "SELECT ISBN,bookname,press,author,borrowablenumber FROM book";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        Book book = null;
        while (rs.next()) {
            book = new Book();
            book.setISBN(rs.getString(1));
            book.setBookname(rs.getString(2));
            book.setPress(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setBorrowablenumber(rs.getInt(5));
            all.add(book);

        }
        this.pstmt.close();
        return all;
    }

    @Override
    public boolean updateBook(Book book) throws Exception{
        boolean flag = false;
        String sql = "UPDATE book SET bookname=? , press=?,author=?,borrowablenumber=? WHERE ISBN=?";
        this.pstmt = this.conn.prepareStatement(sql);
       // System.out.println(book.getClass());
       // System.out.println("updateStu(Book book)");
        this.pstmt.setString(1,book.getBookname());
        this.pstmt.setString(2,book.getPress());
        this.pstmt.setString(3,book.getAuthor());
        this.pstmt.setInt(4,book.getBorrowablenumber());
        this.pstmt.setString(5,book.getISBN());
        if (this.pstmt.executeUpdate()>0){
            //System.out.println("执行修改");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean deleteBook(String ISBN) throws  Exception{
        boolean flag = false;
        String sql = "DELETE FROM book WHERE ISBN = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,ISBN);
        if (this.pstmt.executeUpdate()>0){
       //     System.out.println("执行删除");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public List<Book> findByBookname(String bookname) throws Exception{
        List<Book> all = new ArrayList<Book>() ;
        String sql = "SELECT ISBN,bookname,press,author,borrowablenumber FROM book WHERE bookname=?" ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,bookname);
        ResultSet rs = this.pstmt.executeQuery();
        Book book = null;
        while(rs.next()){
            book = new Book();
            book.setISBN(rs.getString(1));
            book.setBookname(rs.getString(2));
            book.setPress(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setBorrowablenumber(rs.getInt(5));
            all.add(book);
        }
        this.pstmt.close();
        return all;
    }

    public List<Book> findByISBN(String ISBN) throws Exception{
        List<Book> all = new ArrayList<Book>() ;
        String sql = "SELECT ISBN,bookname,press,author,borrowablenumber FROM book WHERE ISBN=?" ;
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1, ISBN);
        ResultSet rs=this.pstmt.executeQuery();
        Book book = null;
        while(rs.next()){
            book = new Book();
            book.setISBN(rs.getString(1));
            book.setBookname(rs.getString(2));
            book.setPress(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setBorrowablenumber(rs.getInt(5));
            all.add(book);
        }
        this.pstmt.close() ;
        return all ;


    }





















































}
