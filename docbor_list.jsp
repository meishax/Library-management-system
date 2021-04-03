<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/10
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.*" %>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>docbor_list</title>

    <style type="text/css">
        #centent{
            margin-top: 10%;
            margin-left: 30%;
        }
        .smart-green {
            margin-left:auto;
            margin-right:auto;
            max-width: 500px;
            background: #F8F8F8;
            padding: 30px 30px 20px 30px;
            font: 18px Arial, Helvetica, sans-serif;
            color: #666;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
        }
        .smart-green h1 {
            font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
            padding: 20px 0px 20px 40px;
            display: block;
            margin: -30px -30px 10px -30px;
            color: #FFF;
            background: #9DC45F;
            text-shadow: 1px 1px 1px #949494;
            border-radius: 5px 5px 0px 0px;
            -webkit-border-radius: 5px 5px 0px 0px;
            -moz-border-radius: 5px 5px 0px 0px;
            border-bottom:1px solid #89AF4C;

        }
        .smart-green h1>span {
            display: block;
            font-size: 11px;
            color: #FFF;
        }

        .smart-green label {
            display: block;
            margin: 0px 0px 5px;
        }
        .smart-green label>span {
            float: left;
            margin-top: 10px;
            color: #5E5E5E;
        }
        .smart-green input[type="text"], .smart-green input[type="email"], .smart-green textarea, .smart-green select {
            color: #555;
            height: 30px;
            line-height:15px;
            width: 70%;
            padding: 0px 0px 0px 10px;
            margin-top: 2px;
            border: 1px solid #E5E5E5;
            background: #FBFBFB;
            outline: 0;
            -webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            font: normal 14px/14px Arial, Helvetica, sans-serif;
        }
        .smart-green textarea{
            height:100px;
            padding-top: 10px;
        }
        .smart-green select {
        nt(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
            appearance:none;
            -webkit-appearance:none;
            -moz-appearance: none;
            text-indent: 0.01px;
            text-overflow: '';
            width:70%;
            height:30px;
        }
        .smart-green .button {
            background-color: #9DC45F;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-border-radius: 5px;
            border: none;
            padding: 10px 25px 10px 25px;
            color: #FFF;
            text-shadow: 1px 1px 1px #949494;
        }
        .smart-green .button:hover {
            background-color:#80A24A;
        }
        #first
        {
            background-color: #9DC45F;
        }
        #second
        {
            background-color: #9DC45F;
        }
        table{
            table-layout:fixed;
            empty-cells:show;
            border-collapse: collapse;
            margin:0 auto;
        }
        td{
            width:120px;
            height:25px;
            border:1px dashed #9DC45F;
            padding:0 1.5em 0;
        }
    </style>

    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/uniform.default.css" rel="stylesheet" type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
    <link href="css/jquery.gritter.css" rel="stylesheet" type="text/css">
    <link href="css/daterangepicker-bs3.css" rel="stylesheet" type="text/css" >
    <link href="css/fullcalendar.css" rel="stylesheet" type="text/css">
    <link href="css/jqvmap.css" rel="stylesheet" type="text/css">
    <link href="css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css">
    <!-- END PAGE LEVEL PLUGIN STYLES -->
    <!-- BEGIN THEME STYLES -->
    <link href="css/style-metronic.css" rel="stylesheet" type="text/css"/>
    <link href="css/style_welcome.css" rel="stylesheet" type="text/css"/>
    <link href="css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="css/tasks.css" rel="stylesheet" type="text/css"/>
    <link href="css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    <link href="css/welcome.css" rel="stylesheet"/>
</head>
<body>

<h1><a class="navbar-brand" href="#" onClick="javascript :history.back(-1);"><font color="red" size="21px">返回</font></a></h1>

<form action="docbor_list" method="post" class="smart-green">
    <h1>信息查询</h1>
    按书籍编号查询：<br>
    请输入查询关键字：
    <input type="text" name="borrowedbookidkw" value="请输入查询信息">
    <input type="submit" value="查询" class="button">
    <br>


    按借阅人学号查询：<br>
    请输入查询关键字：
    <input type="text" name="borrowstudentsnokw" value="请输入查询信息">
    <input type="submit" value="查询" class="button">
</form>





<table class="smart-green"><tr id="first"><td>借阅书籍编号</td><td>书名</td><td>借阅人学号</td><td>借阅人姓名</td><td>删除</td><td>修改</td></tr>

    <c:forEach items="${requestScope.iterone}" var="iterone">
    <tr>
        <td>${iterone.borrowedbookid} </td>
        <td>${iterone.borrowedbookname} </td>
        <td>${iterone.borrowstudentsno} </td>
        <td>${iterone.borrowstudentname} </td>
        <td><a href='docbor_delete?borrowedbookid=${iterone.borrowedbookid}'>delete</a></td>
        <td><a href='docbor_update.jsp'>edit</a></td>
    </tr>
    </c:forEach>





    <br>
    <br>
    <br>






    <table class="smart-green"><tr id="second"><td>借阅书籍编号</td><td>书名</td><td>借阅人学号</td><td>借阅人姓名</td><td>删除</td><td>修改</td></tr>

        <c:forEach items="${requestScope.itertwo}" var="itertwo">
        <tr>
            <td>${itertwo.borrowedbookid} </td>
            <td>${itertwo.borrowedbookname} </td>
            <td>${itertwo.borrowstudentsno} </td>
            <td>${itertwo.borrowstudentname} </td>
            <td><a href='docbor_delete?borrowedbookid=${itertwo.borrowedbookid}'>delete</a></td>
            <td><a href='docbor_update.jsp'>edit</a></td>
        </tr>
        </c:forEach>



</body>
</html>
