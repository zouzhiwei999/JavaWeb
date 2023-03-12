<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.jsp.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2023/2/26
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>

<% ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("StudentList"); %>

<table border="2px">
    <thead>
        <td>姓名</td>
        <td>年龄</td>
        <td>email</td>
    </thead>
    <%
        for (Student student : studentList) {
    %>
        <tr>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getEmail()%></td>
        </tr>

    <%}%>
</table>

</body>
</html>
