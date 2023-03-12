<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: AOA
  Date: 2023/2/27
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Person person = new Person();

    person.setName("王杰");

    String[] phones = new String[4];
    phones[0] = "13533821217";
    phones[1] = "13533821218";
    phones[2] = "13533821219";

    person.setPhone(phones);

    List<String> citylist = new ArrayList<>();
    citylist.add("北京");
    citylist.add("上海");
    citylist.add("广州");

    person.setCitys(citylist);

    Map<String, Object> stringObjectHashMap = new HashMap<>();
    stringObjectHashMap.put("key1", "value1");
    stringObjectHashMap.put("key2", "value2");
    stringObjectHashMap.put("key3", "value3");

    person.setMap(stringObjectHashMap);

    pageContext.setAttribute("p", person);
%>

输出Person:${p}<br>
输出name:${p.name}<br>
输出第二个手机号:${p.phone[1]}<br>
输出第三个城市:${p.citys[2]}<br>
输出第一个map:${p.map.key1}<br>

</body>
</html>
