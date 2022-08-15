<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
4.遍历 List 集合---list 中存放 Student 类，有属性：编号，用户名，密码，年龄，电话信息
--%>

<%
    ArrayList<Student> studentsList = new ArrayList<>();
    for (int i = 1; i <10 ; i++) {
        studentsList.add(new Student(i,"username"+i,"password"+i,18+i,"phone"+i));

    }
    request.setAttribute("stus",studentsList);
%>
<c:forEach items="${requestScope.stus}" var="item">
    ${item}<br/>

</c:forEach>

</body>
</html>
