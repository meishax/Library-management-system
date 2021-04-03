<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/4
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
    <meta name="keywords" content="keywords">
    <meta name="description" content="description">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body class="templatemo-bg-gray">

<div class="col-md-12">
    <h1 class="margin-bottom-15">密码找回</h1>
    <form class="form-horizontal templatemo-forgot-password-form templatemo-container"
          role="form" action="login.jsp" method="post">
        <div class="form-group">
            <div class="col-md-12">请输入注册邮箱</div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <input type="text" class="form-control" name="email"
                       placeholder="Your email">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <input type="submit" value="提交" class="btn btn-danger"> <br>

                <br> <a href="login.jsp">返回登录界面</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>