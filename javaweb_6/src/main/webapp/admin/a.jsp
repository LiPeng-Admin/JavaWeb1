<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/9/10
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp执行了");
    Object user = session.getAttribute("user");
    if (user == null) {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }
%>
我是a.jsp文件

</body>
</html>
