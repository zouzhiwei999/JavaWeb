<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/23
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="http://localhost:80/09_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名:<input type="text" name="username"> <br>
        头像:<input type="file" name="photo"> <br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
