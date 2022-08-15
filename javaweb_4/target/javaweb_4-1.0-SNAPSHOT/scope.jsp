<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/14
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
pageScope ====== pageContext 域
requestScope ====== Request 域
sessionScope ====== Session 域
applicationScope ====== ServletContext 域
--%>
<%
    pageContext.setAttribute("key1", "pageScope");
    request.setAttribute("key1", "requestScope");
    session.setAttribute("key1", "sessionScope");
    application.setAttribute("key1", "applicationScope");
%>
${pageScope.key1}<br/>
<%--${requestScope.key1}<br/>--%>
<%--${sessionScope.key1}<br/>--%>
<%--${applicationScope.key1}<br/>--%>

</body>
</html>
