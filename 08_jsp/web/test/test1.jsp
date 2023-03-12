<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/21
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
<table border="2px">
    <%
        for (int i = 1; i < 10; i++) {
    %>
    <tr>
    <%
            for (int j = 1; j<=i; j++) {
    %>
    <td>
    <%= j %>*<%= i %>=<%= i*j %>
    </td>
    <%
            }
    %>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
