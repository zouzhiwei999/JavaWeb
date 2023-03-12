<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2023/2/28
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("REQ", "这里是request域存的值");
%>

1.协议：         <%=request.getScheme()%><br>
2.服务器 ip：     <%=request.getServerName()%><br>
3.服务器端口：      <%=request.getServerPort()%><br>
4.获取工程路径：     <%=request.getContextPath()%><br>
5.获取请求方法：     <%=request.getMethod()%><br>
6.获取客户端 ip 地址：<%=request.getRemoteHost()%><br>
7.获取会话的 id 编号：<%=session.getId()%><br>

1.协议：            ${ pageContext.request.scheme }<br>
2.服务器 ip：       ${ pageContext.request.serverName }<br>
3.服务器端口：       ${ pageContext.request.serverPort }<br>
4.获取工程路径：      ${ pageContext.request.contextPath }<br>
5.获取请求方法：       ${ pageContext.request.method }<br>
6.获取客户端 ip 地址：${ pageContext.request.remoteHost }<br>
7.获取会话的 id 编号：${ pageContext.session.id }<br>

1.协议：            ${requestScope.REQ}<br>
2.服务器 ip：       ${requestScope.serverName}<br>
3.服务器端口：       ${requestScope.serverPort }<br>
4.获取工程路径：      ${requestScope.contextPath  }<br>
5.获取请求方法：       ${requestScope.method  }<br>
6.获取客户端 ip 地址：${requestScope.remoteHost  }<br>
7.获取会话的 id 编号：${sessionScope.id  }<br>

</body>
</html>
