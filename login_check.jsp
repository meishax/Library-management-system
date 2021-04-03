<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/4
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>登录校验</title>
</head>
<%!	// 定义若干个数据库的连接常量
    public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
    public static final String DBURL = "jdbc:mysql://localhost:3306/experiment_3?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DBUSER = "root" ;
    public static final String DBPASS = "admin123" ;
%>
<%
    Connection conn = null ;		// 数据库连接
    PreparedStatement pstmt = null ;	// 数据库预处理操作
    ResultSet rs = null ;		// 查询要处理结果集
    boolean flag = false ;	// 保存标记
    boolean flagId = false ;
    String name = null ;	//
    String id = null ;

%>
<%
    try{
        Class.forName(DBDRIVER) ;
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
        String sql = "SELECT username FROM login WHERE username=? AND password=? AND identityx=?" ;
        pstmt = conn.prepareStatement(sql) ;
        pstmt.setString(1,request.getParameter("username")) ;
        pstmt.setString(2,request.getParameter("password")) ;
        pstmt.setString(3,request.getParameter("identityx")) ;
        rs = pstmt.executeQuery() ;// 查询
        if(rs.next()){// 如果有数据，则可以执行

            flag = true ;//  表示登陆成功
            name = rs.getString(1) ;
            id = request.getParameter("identityx");

            session.setAttribute("userName", name);
            session.setAttribute("identityx",id);




            if (id.equals("admin")) {
                flagId = true;
            }
            else{
                flagId = false;

            }
        }
    }catch(Exception e){
        e.printStackTrace() ;
    }
    finally{
        try{
            rs.close() ;
            pstmt.close() ;
            conn.close() ;
        } catch(Exception e){}
    }
%>
<%
    if(flag){// 登陆成功

        if (flagId)
        {// 管理员
%>

<jsp:forward page="welcome.jsp">
    <jsp:param name="username" value="<%=name%>"/>
    <jsp:param name="identityx" value="<%=id%>"/>
</jsp:forward>


<%
        } else {//普通用户
%>

<jsp:forward page="welcome_user.jsp">
    <jsp:param name="username" value="<%=name%>"/>
    <jsp:param name="identityx" value="<%=id%>"/>
</jsp:forward>


<%
        }
    }
    else {// 登陆失败
%>
<jsp:forward page="login_failure.jsp"/>
<%
    }
%>
</body>
</html>