<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/21
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <% request.setAttribute("key", "request域值"); %>
  <br>

  jsp表达式：
  <%=request.getAttribute("key1")==null? "" :request.getAttribute("key1")%>zzzzzz

  <br>
  EL表达式${key1}zzzzzz

  </body>
</html>
