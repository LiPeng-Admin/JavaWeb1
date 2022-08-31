<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/30
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/javaweb_5/">

</head>
<body>
<form method="get" action="loginServlet">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="登录">

</form>

</body>
</html>
