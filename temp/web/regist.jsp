<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/29
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="http://localhost:8080/temp/registServlet" method="get">
        用户名<input type="text" name="user"> <br>
        验证码<input type="text" name="code"> <img src="http://localhost:8080/temp/kaptchaServlet.jpg" style="width: 160px;"> <br/>
        <input type="submit" value="提交">
    </form>


</body>
</html>
