<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/3
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册 - </title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/regAcc.css"/>
    <link rel="icon" href="graph/icon.png"/>
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        body
        {
            background: url('graph/Login_background.jpg') no-repeat center center fixed;
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><span class="icon-cloud"></span>管理员系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav pull-right">
                <li><a id="qrcode_nav" href="#">关于我们</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!--导航栏结束-->
<div id="head-div">
    <a href="index.jsp"><span class="icon-home" style="font-size: xx-large"></span></a>
</div>
<h4>填写信息,注册为管理员</h4>
<div id="form-reg" ng-app="myApp">
    <form id="form1" ng-controller="samePass" action="signup" method="post">

        <div id="div-user_name" class="input-group">
            <span class="input-group-addon" id="sizing-addon2"><i class="glyphicon glyphicon-user"></i></span>
            <input name="username" required id="username" type="text" class="form-control" placeholder="用户名" onblur="checkusername()" oninput="checkusername()" value=""/>
        </div>
        <span id="sameUsername" style="color: green;visibility: visible">* 用户名6-16位</span>
        <span id="errorusername" style="color: red;visibility: visible"> </span>
        <span id="s1">　</span>


        <div id="div-email_address" class="input-group">
            <span class="input-group-addon"><i class="icon-envelope"></i></span>
            <input name="email" id="email" class="form-control" type="text" placeholder="邮箱地址" onblur="checkemail()" oninput="checkemail()" value=""/>
        </div>
        <span id="erroremail" style="color: red;visibility: visible"></span>
        <span id="s3"  >　</span>


        <div id="div-password" class="input-group">
            <span class="input-group-addon"><i class="icon-key"></i></span>
            <input name="password" id="password" class="form-control" ng-model="pass" type="password" placeholder="设置密码" onblur="checkpassword()" oninput="checkpassword()" value=""/>
        </div>
        <span id="samepassword" style="color: green;visibility: visible">* 密码为4~8位</span>
        <span id="errorpassword" style="color: red;visibility: visible"> </span>
        <span id="s2">　</span>

        <div id="div-password-again" class="input-group">
            <span class="input-group-addon"><i class="icon-key"></i></span>
            <input name="passwordagain" id="passwordagain" class="form-control" ng-model="passA" type="password" placeholder="再次输入密码"  onblur="checksamepassword()" oninput="checksamepassword()" value=""/>
        </div>
        <span id="errorpasswordagain" style="color: red;visibility: visible"></span>
        <span id="s4"></span>

        <br>

        <input type="radio" name="identityx" value="user"  style="vertical-align:middle;"/>用户
        <span class="bank15"></span><span class="bank15"></span>
        <input type="radio" name="identityx" value="admin" style="vertical-align:middle;"/>管理员

        <input type="submit" value="注册" class="btn-block btn-success">


    </form>
</div>
<div id="qrCode">
    <img src="graph/wxqrcode.png" class="img-responsive"/>
</div>
<div id="foot-div">
    <div>
        郭子杨 08173042 计科17-06
    </div>
</div>
</body>
</html>