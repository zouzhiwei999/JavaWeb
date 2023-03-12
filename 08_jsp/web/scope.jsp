<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/20
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这里是scope</title>
</head>
<body>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext是否有值: <%=pageContext.getAttribute("key")%> <br>
request是否有值: <%=request.getAttribute("key")%> <br>
session是否有值: <%=session.getAttribute("key") %> <br>
application是否有值: <%=application.getAttribute("key")%> <br>

<%
    request.getRequestDispatcher("/scope2.jsp").forward(request, response);
%>
</body>
</html>
