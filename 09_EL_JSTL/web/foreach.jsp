<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2022/4/22
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <c:forEach begin="1" end="10" var="i" >
        <tr>
            <td>
                第 ${ i } 个
            </td>
        </tr>
    </c:forEach>
</table>

<hr>
<h1>遍历对象类型的数组</h1>

<%
    request.setAttribute("name", new String[]{"刘德华","张学友","黎明"});
%>

<c:forEach var="item" items="${requestScope.name}">

    ${ item } <br>

</c:forEach>

<hr>

<%--jsp--%>
<%
    Map<String, Object> HashMap = new HashMap<>();
    HashMap.put("key1", "value1");
    HashMap.put("key2", "value2");
    HashMap.put("key3", "value3");

    request.setAttribute("map", HashMap);
%>

<hr>

${requestScope.map.key1}

<hr>

<%--JSTL--%>

<c:forEach items="${requestScope.map}" var="i" >
    <h1>${i.key} = ${i.value}</h1>
</c:forEach>

<hr>

<h1>遍历Student</h1>
<%
    List<Student> studentsList = new ArrayList<>();

    Student name1 = new Student(1, "李白", "123456", 18, "156456312");
    Student name2 = new Student(2, "杜甫", "25252", 28, "252252158");
    Student name3 = new Student(3, "白居易", "523456", 19, "587545242");

    studentsList.add(name1);
    studentsList.add(name2);
    studentsList.add(name3);

    request.setAttribute("stuList", studentsList);
%>

<table border="1 , collapse" width="700" align="center">
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>密码</td>
        <td>你他妈几岁了</td>
        <td>电话</td>
        <td>属性</td>
    </tr>

    <c:forEach begin="0" end="3" step="1" varStatus="status" items="${ requestScope.stuList }" var="sl">
        <tr>
            <td>${ sl.id }</td>
            <td>${ sl.username }</td>
            <td>${ sl.password }</td>
            <td>${ sl.age }</td>
            <td>${ sl.phone }</td>
            <td>${ status.first }</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
