<%--
  Created by IntelliJ IDEA.
  User: 郭子杨
  Date: 2020/4/8
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>StuListsuccess</title>
</head>
<body>
成功<br>

<%
    List<String> info = (List<String>) request.getAttribute("info") ;
    if(info != null){	// 有信息返回
        Iterator<String> iter = info.iterator() ;
        while(iter.hasNext()){
%>
<h1><%=iter.next()%></h1>
<%
        }
    }
%>
<h1><c:forEach items="${requestScope.info}" var="infoi"> ${infoi} </c:forEach>
</h1>

</body>
</html>
