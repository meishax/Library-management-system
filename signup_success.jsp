<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/4
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <html>
    <head>

        <title>注册成功</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    </head>
<body class="templatemo-bg-gray">

<div class="col-md-12">
    <form class="form-horizontal templatemo-forgot-password-form templatemo-container">
        <%
            response.setHeader("refresh","2;url=login.jsp");
        %>
        <h2>注册成功，2秒后跳转至登录页面</h2>

    </form>
</div>
</body>
</html>