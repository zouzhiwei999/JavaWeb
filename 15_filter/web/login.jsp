<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/5/1
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <base href="http://localhost:80/15_filter/">
</head>
<body>
<%
    System.out.println("login页面");
%>
这里是登录界面
<form action="loginServlet" method="get">
    用户名:<input type="text" name="username"> <br/>
    密&nbsp;码<input type="password" name="password"> <br/>
    <input type="submit" value="提交">
<form>


</body>
</html>
