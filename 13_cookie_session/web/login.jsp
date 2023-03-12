<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2023/3/1
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="http://localhost:80/13_cookie_session/loginServlet">
    账号:<input type="text" name="username" value="${cookie.username.value}"> <br>
    密码:<input type="password" name="password"> <br>
    <input type="submit" value="提交">
</form>

</body>
</html>
