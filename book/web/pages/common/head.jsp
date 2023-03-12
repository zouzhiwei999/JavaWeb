<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/24
  Time: 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme()
                    + "://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()//返回  "/工程路径"，所以不需要前面加"/"
                    + "/";

    pageContext.setAttribute("basePath", basePath);
%>

<base href="<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
