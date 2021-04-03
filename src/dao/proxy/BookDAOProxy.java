package dao.proxy;
import dao.*;
import dao.impl.BookDAOImpl;
import java.sql.*;
import java.util.List;
import dbc.*;
import vo.*;

public class BookDAOProxy implements IBookDAO{
    private DatabaseConnection dbc = null;
    private IBookDAO dao = null;

    public BookDAOProxy() throws  Exception{
        this.dbc = new DatabaseConnection();
        this.dao = new BookDAOImpl(this.dbc.getConn());
    }

    @Override
    public boolean doCreateBook(Book book) throws Exception{
        boolean flag = false;
        try{
            boolean flagunique = true;
            if (this.dao.findByISBN(book.getISBN()).size() != 0){
                flagunique = false;
            }
            if (flagunique){
                flag = this.dao.doCreateBook(book);
            }
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public boolean deleteBook(String ISBN) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByISBN(ISBN).size() != 0){
                flag = this.dao.deleteBook(ISBN);
            }
        }catch (Exception e)
        {
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public boolean updateBook(Book book) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByISBN(book.getISBN()).size() != 0){
                flag = this.dao.updateBook(book);
            }
        }catch (Exception e)
        {
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<Book> findAllBook() throws Exception{
        List <Book> all = null;
        try {
            all = this.dao.findAllBook();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

    @Override
    public List<Book> findByBookname(String bookname) throws Exception{
        List <Book> all = null;
        try{
            all = this.dao.findByBookname(bookname);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }


    @Override
    public List<Book> findByISBN(String ISBN) throws Exception{
        List <Book> all = null;
        try{
            all = this.dao.findByISBN(ISBN);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }
}
