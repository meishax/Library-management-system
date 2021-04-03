package dao.proxy;

import dao.*;
import dao.impl.DocBorDAOImpl;
import java.sql.*;
import java.util.List;
import dbc.*;
import vo.*;

public class DocBorDAOProxy implements IDocBorDAO{
    private DatabaseConnection dbc = null;
    private IDocBorDAO dao = null;

    public DocBorDAOProxy() throws  Exception{
        this.dbc = new DatabaseConnection();
        this.dao = new DocBorDAOImpl(this.dbc.getConn());
    }

    @Override
    public boolean doCreateDocBor(DocBor docbor) throws Exception{
        boolean flag = false;
        try{
            boolean flagunique = true;
            if (this.dao.findByBorrowedbookid(docbor.getBorrowedbookid()).size() != 0){
                flagunique = false;
            }
            if (flagunique){
                flag = this.dao.doCreateDocBor(docbor);
            }
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public boolean deleteDocBor(String borrowedbookid) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByBorrowedbookid(borrowedbookid).size() != 0){
                flag = this.dao.deleteDocBor(borrowedbookid);
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
    public boolean updateDocBor(DocBor docbor) throws Exception{
        boolean flag = false;
        try {
            if (this.dao.findByBorrowedbookid(docbor.getBorrowedbookid()).size() != 0){
                flag = this.dao.updateDocBor(docbor);
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
    public List<DocBor> findAllDocBor() throws Exception{
        List <DocBor> all = null;
        try {
            all = this.dao.findAllDocBor();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

    @Override
    public List<DocBor> findByBorrowedbookid(String borrowedbookid) throws Exception{
        List <DocBor> all = null;
        try{
            all = this.dao.findByBorrowedbookid(borrowedbookid);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

    @Override
    public List<DocBor> findByBorrowstudentsno(String borrowstudentsno) throws Exception{
        List <DocBor> all = null;
        try{
            all = this.dao.findByBorrowstudentsno(borrowstudentsno);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }


























}
