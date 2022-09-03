<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="get" action="registerServlet?action=register">
    用户名:<input type="text" name="username" ><br/>
    验证码:<input type="text" name="code" style="width:80px"><img src="http://localhost:8080/temp/kaptcha.jpg" style="width: 80px; height: 25px"><br/>

    <input type="submit" value="注册">

</form>
</body>
</html>