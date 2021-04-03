package dao.impl;

import vo.*;
import dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StuDAOImpl implements IStuDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement s = null;

    public StuDAOImpl(Connection conn) {
        this.conn = conn;

    }

    public boolean doCreateStu(Stu stu) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO student(sno,sname,sclass,smajor,borrownumber) VALUES (?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        //System.out.println(stu.getClass());
        //System.out.println("这是doCreateStu(Stu stu)");
        this.pstmt.setString(1, stu.getSno());
        this.pstmt.setString(2, stu.getSname());
        this.pstmt.setString(3, stu.getSclass());
        this.pstmt.setString(4, stu.getSmajor());
        this.pstmt.setInt(5, stu.getBorrownumber());
       // pstmt.execute();
        if (this.pstmt.executeUpdate() > 0) {
            //System.out.println("执行插入");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean updateStu(Stu stu) throws Exception{
        boolean flag = false;
        String sql = "UPDATE student SET sname=? , sclass=? ,smajor=? , borrownumber=? WHERE sno=?";
        this.pstmt = this.conn.prepareStatement(sql);
        //System.out.println(stu.getClass());
        //System.out.println("updateStu(Stu stu)");
        this.pstmt.setString(1,stu.getSname());
        this.pstmt.setString(2,stu.getSclass());
        this.pstmt.setString(3,stu.getSmajor());
        this.pstmt.setInt(4,stu.getBorrownumber());
        this.pstmt.setString(5,stu.getSno());
        if (this.pstmt.executeUpdate()>0){
            //System.out.println("执行修改");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean deleteStu(String sno) throws Exception{
        boolean flag = false;
        String sql = "DELETE FROM student WHERE sno = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,sno);
            if (this.pstmt.executeUpdate()>0){
           // System.out.println("执行删除");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public List<Stu> findAllStu() throws Exception {
        List<Stu> all = new ArrayList<Stu>();
        String sql = "SELECT sno,sname,sclass,smajor,borrownumber FROM student";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        Stu stu = null;
        while (rs.next()) {
            stu = new Stu();
            stu.setSno(rs.getString(1));
            stu.setSname(rs.getString(2));
            stu.setSclass(rs.getString(3));
            stu.setSmajor(rs.getString(4));
            stu.setBorrownumber(rs.getInt(5));
            all.add(stu);
        }
        this.pstmt.close();
        return all;
    }

    public List<Stu> findBySno(String sno) throws Exception{
        List<Stu> all = new ArrayList<Stu>() ;
        String sql = "SELECT sno,sname,sclass,smajor,borrownumber FROM student WHERE sno=?" ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,sno);
        ResultSet rs = this.pstmt.executeQuery();
        Stu stu = null;
        while(rs.next()){
            stu = new Stu();
            stu.setSno(rs.getString(1));
            stu.setSname(rs.getString(2));
            stu.setSclass(rs.getString(3));
            stu.setSmajor(rs.getString(4));
            stu.setBorrownumber(rs.getInt(5));
            all.add(stu);
        }
        this.pstmt.close();
        return all;
    }

    public List<Stu> findByBorrownumber(int borrownumber) throws Exception{
        List<Stu> all = new ArrayList<Stu>() ;
        String sql = "SELECT sno,sname,sclass,smajor,borrownumber FROM student WHERE borrownumber=?" ;
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, borrownumber);
        ResultSet rs=this.pstmt.executeQuery();
        Stu stu=null;
        while(rs.next()){
            stu=new Stu();
            stu.setSno(rs.getString(1));
            stu.setSname(rs.getString(2));
            stu.setSclass(rs.getString(3));
            stu.setSmajor(rs.getString(4));
            stu.setBorrownumber(rs.getInt(5));
            all.add(stu) ;
        }
        this.pstmt.close() ;
        return all ;


    }


































}



