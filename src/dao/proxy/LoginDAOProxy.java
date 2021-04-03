package dao.proxy;

import dao.*;
import dao.impl.LoginDAOImpl;
import java.sql.*;
import java.util.List;
import dbc.*;
import vo.*;

public class LoginDAOProxy implements ILoginDAO{

    private DatabaseConnection dbc = null;
    private ILoginDAO dao = null;

    public LoginDAOProxy() throws  Exception{
        this.dbc = new DatabaseConnection();
        this.dao = new LoginDAOImpl(this.dbc.getConn());
    }

    @Override
    public boolean doCreateLogin(Login login) throws Exception{
        boolean flag = false;
        try{
            boolean flagunique = true;
            if (this.dao.findByUsername(login.getUsername()).size() != 0){
                flagunique = false;
            }
            if (flagunique){
                flag = this.dao.doCreateLogin(login);
            }
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public boolean deleteLogin(String username) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByUsername(username)!=null){
                flag = this.dao.deleteLogin(username);
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
    public boolean updateLogin(Login login) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByUsername(login.getUsername())!=null){
                flag = this.dao.updateLogin(login);
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
    public List<Login> findByUsername(String username) throws Exception{
        List <Login> all = null;
        try{
            all = this.dao.findByUsername(username);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }






}
