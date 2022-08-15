<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  request.setAttribute("key1", "value1");
%>
表达式脚本输出的key值是：<%=request.getAttribute("key1")%><br />
<%--
--%>
EL 输出的key1值是：${key1}

</body>
</html>
