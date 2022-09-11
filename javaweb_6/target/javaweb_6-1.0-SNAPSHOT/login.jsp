<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/9/10
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/javaweb_6/">
</head>

<body>
<%--这是登录页面。login.jsp<br />--%>
<form method="get" action="loginServlet">
    用户名：<input type="text" name="username"><br />
    密 码：<input type="password" name="password"><br />
    <input type="submit">



</form>

</body>
</html>
