package dao.proxy;

import dao.*;
import dao.impl.StuDAOImpl;
import java.sql.*;
import java.util.List;
import dbc.*;
import vo.*;

public class StuDAOProxy implements IStuDAO{
    private DatabaseConnection dbc = null;
    private IStuDAO dao = null;

    public StuDAOProxy() throws  Exception{
        this.dbc = new DatabaseConnection();
        this.dao = new StuDAOImpl(this.dbc.getConn());
    }

    public boolean doCreateStu(Stu stu) throws Exception{
        boolean flag = false;
        try{
            boolean flagunique = true;
            if (this.dao.findBySno(stu.getSno()).size() != 0){
                flagunique = false;
            }
            if (flagunique){
                flag = this.dao.doCreateStu(stu);
            }
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public boolean updateStu(Stu stu) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findBySno(stu.getSno()).size() != 0){
                flag = this.dao.updateStu(stu);
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
    public boolean deleteStu(String sno) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findBySno(sno).size() != 0){
                flag = this.dao.deleteStu(sno);
            }
        }catch (Exception e)
        {
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    public List<Stu> findAllStu() throws Exception{
        List <Stu> all = null;
        try {
            all = this.dao.findAllStu();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

    @Override
    public List<Stu> findByBorrownumber(int borrownumber) throws Exception{
        List <Stu> all = null;
        try{
            all = this.dao.findByBorrownumber(borrownumber);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }



    @Override
    public List<Stu> findBySno(String sno) throws Exception{
        List <Stu> all = null;
        try{
            all = this.dao.findBySno(sno);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

















}
