<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/14
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="http://localhost:8080/javaweb_4/uploadServlet">
    用户名：<input type="text" name="username"><br/>
    头像:<input type="file" name="photo"><br/>
   <input type="submit" value="上传"><br/>
</form>

</body>
</html>
