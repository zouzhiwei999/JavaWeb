<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/20
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--声明类属性--%>
<%!


%>

<%--代码脚本--%>
<%=request.getParameter("username") %>

<%
    String username = request.getParameter("username");
    System.out.println("请求餐宿" + username);
%>


</body>
</html>
