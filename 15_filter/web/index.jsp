<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/5/1
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <base href="http://localhost:80/15_filter/">
  <body>
  這裏是index.jsp
  <%
    Object username = session.getAttribute("username");

    if(username == null) {
      request.getRequestDispatcher("login.jsp").forward(request,response);
    }
  %>
  </body>
</html>
