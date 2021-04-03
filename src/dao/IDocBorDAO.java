package dao;

import vo.*;

import java.util.List;
public interface IDocBorDAO {
    public boolean doCreateDocBor(DocBor docbor) throws Exception ;//执行数据的插入操作
    public List<DocBor> findAllDocBor() throws Exception ;//完成数据 的查询操作
    public List<DocBor> findByBorrowedbookid(String borrowedbookid) throws Exception ;//根据书id，返回所有DocBor
    public List<DocBor> findByBorrowstudentsno(String borrowstudentsno) throws Exception;// 根据借阅人学号，返回DocBor
    public boolean deleteDocBor(String borrowedbookid) throws Exception;
    public boolean updateDocBor(DocBor docbor) throws Exception;
}
