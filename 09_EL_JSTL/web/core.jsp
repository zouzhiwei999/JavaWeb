<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/22
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${ requestScope.abc } <br>

<c:set scope="request" var="abc" value="zzw"/>

${ requestScope.abc }

<hr>

<c:if test="${ 12 == 12 }">
    <h1>你妹的</h1>
</c:if>

</body>
</html>
