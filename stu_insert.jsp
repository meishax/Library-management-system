<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/8
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.*" %>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>stu_insert</title>

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
            width: 100%;
            padding: 0px 0px 0px 10px;
            margin-top: 2px;
            border: 1px solid #E5E5E5;
            background: #FBFBFB;
            outline: 0;
            -webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            font: normal 18px/18px Arial, Helvetica, sans-serif;
        }
        .smart-green textarea{
            height:100px;
            padding-top: 10px;
        }
        .smart-green select {
            appearance:none;
            -webkit-appearance:none;
            -moz-appearance: none;
            text-indent: 0.01px;
            text-overflow: '';
            width:100%;
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
<form action="stu_insert" method="post" class="smart-green">
    <h1>请输入添加学生信息：</h1><br>
    <label>
        <span>学号：</span>
        <input type="text" name="sno"  />
    </label>
    <label>
        姓名：<input type="text" name="sname"><br>
        班级：
        <select name="sclass">
            <option value="0">请选择一个班级
            <option value="计科一班">计科一班
            <option value="计科二班">计科二班
            <option value="计科三班">计科三班
            <option value="计科四班">计科四班
            <option value="计科五班">计科五班
            <option value="计科六班">计科六班
            <option value="信安一班">信安一班
            <option value="信科一班">信科一班
            
        </select>
        <br>
        专业：
        <select name="smajor">
            <option value="0">请选择专业
            <option value="计算机科学与技术">计算机科学与技术
            <option value="信息安全">信息安全
            <option value="电子信息科学与技术">电子信息科学与技术
        </select>
        <br>
        借阅量：<input type="text" name="borrownumber" value="0" readonly="readonly"><br>
        <label>
            <span>&nbsp;</span>
            <br>
            <input type="submit" class="button" value="添加">
            <input type="reset"  class="button" value="重置">
        </label>
    </label>
</form>

</body>
</html>
