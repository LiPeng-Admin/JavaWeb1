<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/error500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
errorPage 表示错误发生后自动跳转去的路径,这个路径一般是以/开头，它表示请求的地址为http://ip:port/工程路径/，映射到代码的web目录
--%>
<%
    int  i=12/0;
%>

</body>
</html>
