package dao;

import vo.*;

import java.util.List;

public interface IBookDAO {
    public boolean doCreateBook(Book book) throws Exception ;//执行数据的插入操作
    public List<Book> findAllBook() throws Exception ;//完成数据 的查询操作
    public List<Book> findByBookname(String bookname) throws Exception ;//根据书名查询，返回所有Book
    public List<Book> findByISBN(String ISBN) throws Exception;// 根据借阅余量查询，返回Book
    public boolean deleteBook(String ISBN) throws Exception;
    public boolean updateBook(Book book) throws Exception;
}
