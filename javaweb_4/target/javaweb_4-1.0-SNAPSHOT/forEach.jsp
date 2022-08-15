<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--1.遍历 1 到 10，输出
begin 属性设置开始的索引
end 属性设置结束的索引
var 属性表示循环的变量(也是当前正在遍历到的数据)
for (int i = 1; i < 10; i++)
--%>
<c:forEach begin="1" end="10" var="i">
    ${i}

</c:forEach>
<br/>

<%--
2.遍历 Object 数组
for (Object item: arr)
items 表示遍历的数据源（遍历的集合）
var 表示当前遍历到的数据
--%>
<%
    request.setAttribute("arr", new String[]{"18654119611", "18654119622", "18654119600"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}

</c:forEach>
<br/>
<%
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");


    request.setAttribute("map", map);
%>

<c:forEach items="${requestScope.map}" var="entry">
    ${entry.value}

</c:forEach>

</body>
</html>
