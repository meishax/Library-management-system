<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/10
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>welcome</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="description" name="description">
    <meta content="author" name="author">
    <meta name="admin" content="admin">
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
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
<body class="page-header-fixed">

<%if( session.getAttribute("userName")!=null){
%>


<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="header-inner">
        <!-- BEGIN LOGO -->
        <a class="navbar-brand" href="index.jsp">首页</a>
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <img src="graph/menu-toggler.png" alt="" />
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <ul class="nav navbar-nav pull-right">

            <li class="dropdown user">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <img alt="" src="graph/avatar1_small.jpg">
                    <span class="username"><%=session.getAttribute("userName")%></span>
                    <span><a style="color: #4d90fe;font-size:20px;" href="logout.jsp">注销</a></span>
                    <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-user"></i>个人信息</a></li>

                    <li class="divider"></li>
                    <li><a href="javascript:;" id="trigger_fullscreen"><i class="fa fa-move"></i> 全屏</a></li>
                    <li><a href="#"><i class="fa fa-lock"></i> 锁屏</a></li>
                    <li><a href="#"><i class="fa fa-key"></i> 退出</a></li>
                </ul>
            </li>
            <!-- END USER LOGIN DROPDOWN -->
        </ul>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <ul class="page-sidebar-menu">
            <li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <li>
                <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                <form class="sidebar-search" action="extra_search.html" method="POST">
                    <div class="form-container">
                        <div class="input-box">
                            <a href="javascript:;" class="remove"></a>
                            <input type="text" placeholder="搜索..."/>
                            <input type="button" class="submit" value=" "/>
                        </div>
                    </div>
                </form>
                <!-- END RESPONSIVE QUICK SEARCH FORM -->
            </li>
            <li class="首页">
                <a href="welcome_user.jsp">
                    <i class="fa fa-home"></i>
                    <span class="title">首页</span>
                    <span class="selected"></span>
                </a>
            </li>

            <li class="个人信息增加">
                <a href="stu_insert.jsp">
                    <i class="fa fa-cogs"></i>
                    <span class="title">个人信息增加</span>
                    <span class="arrow "></span>
                </a>

            </li>

            <li class="个人信息修改">
                <a href="stu_update.jsp">
                    <i class="fa fa-cogs"></i>
                    <span class="title">个人信息修改</span>
                    <span class="arrow "></span>
                </a>

            </li>

            <li class="个人信息查询">
                <a href="stu_list.jsp">
                    <i class="fa fa-bookmark-o"></i>
                    <span class="title">个人信息查询</span>
                    <span class="arrow "></span>
                </a>

            </li>
            <li class="书籍查询">
                <a href="book_list.jsp">
                    <i class="fa fa-table"></i>
                    <span class="title">书籍查询</span>
                    <span class="arrow "></span>
                </a>
            </li>

            <li class="借阅信息查询">
                <a href="docbor_list.jsp">
                    <i class="fa fa-table"></i>
                    <span class="title">借阅信息查询</span>
                    <span class="arrow "></span>
                </a>
            </li>

        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN PAGE -->
    <div class="page-content">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <!-- END BEGIN STYLE CUSTOMIZER -->
        <!-- BEGIN PAGE HEADER-->

        <h1 align="center">欢迎页</h1>
        <table class="table table-striped">
            <tr>


            </tr>


        </table>
        <tr>
            <h1><font color="#7fff00">欢迎<%=session.getAttribute("userName")%>登入</font></h1>

        </tr>

        <!-- END PAGE HEADER-->
        <!-- BEGIN DASHBOARD STATS -->

        <!-- END DASHBOARD STATS -->

    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="footer-inner">
        郭子杨 08173042 计科17-06
    </div>
    <div class="footer-tools">
			<span class="go-top">
			<i class="fa fa-angle-up"></i>
			</span>
    </div>
</div>

<%
} else{
%>

<div class="center">
    <div class="center_text">
        请您先去<a href="login.jsp">登陆</a>！
    </div>
    <br>
</div>


<%
    }
%>



</body>
</html>
