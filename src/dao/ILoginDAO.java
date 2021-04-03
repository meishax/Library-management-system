package dao;

import vo.*;

import java.util.List;

public interface ILoginDAO {
    public boolean doCreateLogin(Login login) throws Exception ;//执行数据的插入操作
    public List<Login> findByUsername(String username) throws Exception ;
    public boolean deleteLogin(String username) throws Exception;
    public boolean updateLogin(Login login) throws Exception;
}
