package dao.impl;
import vo.*;
import dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements ILoginDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public LoginDAOImpl(Connection conn) {
        this.conn = conn;

    }
    public boolean doCreateLogin(Login login) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO login(username, password, identityx) VALUES (?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        //System.out.println(login.getClass());
        //System.out.println("doCreateLogin(Login login)");
        this.pstmt.setString(1, login.getUsername());
        this.pstmt.setString(2, login.getPassword());
        this.pstmt.setString(3, login.getIdentityx());
        if (this.pstmt.executeUpdate() > 0) {
           // System.out.println("执行插入");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean updateLogin(Login login) throws Exception{
        boolean flag = false;
        String sql = "UPDATE login SET password=? , identityx=? WHERE username=?";
        this.pstmt = this.conn.prepareStatement(sql);
        System.out.println(login.getClass());
        System.out.println("updateStu(Logn login)");
        this.pstmt.setString(1,login.getPassword());
        this.pstmt.setString(2,login.getIdentityx());
        this.pstmt.setString(3,login.getUsername());
        if (this.pstmt.executeUpdate()>0){
            System.out.println("执行修改");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean deleteLogin(String username) throws Exception{
        boolean flag = false;
        String sql = "delete from login where username = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,username);
        if (this.pstmt.executeUpdate()>0){
            System.out.println("执行删除");
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public List<Login> findByUsername(String username) throws Exception{
        List<Login> all = new ArrayList<Login>() ;
        String sql = "SELECT username,password,identityx FROM login WHERE username=?" ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,username);
        ResultSet rs = this.pstmt.executeQuery();
        Login login = null;
        while(rs.next()){
            login = new Login();
            login.setUsername(rs.getString(1));
            login.setPassword(rs.getString(2));
            login.setIdentityx(rs.getString(3));
            all.add(login);
        }
        this.pstmt.close();
        return all;
    }




















































































}
