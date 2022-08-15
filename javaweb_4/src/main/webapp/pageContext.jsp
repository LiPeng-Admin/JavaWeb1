<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/14
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
jsp 九大内置对象
 request 请求对象 response 响应对象 pageContext jsp 的上下文对象 session 会话对象 application ServletContext 对象 config
ServletConfig 对象 out jsp输出流对象 page 指向当前jsp 的对象 exception 异常对象
--%>
<%--${ pageContext.request}--%>
<%--
1. 协议：
2. 服务器 ip：
3. 服务器端口：
4. 获取工程路径：
5. 获取请求方法：
6. 获取客户端 ip 地址：
7. 获取会话的 id 编号
--%>
<%--1. 协议：--%>
${pageContext.request.scheme}<br />
<%--2. 服务器 ip：--%>
${pageContext.request.serverName}<br />
<%--3. 服务器端口：--%>
${pageContext.request.serverPort}<br />
<%--4. 获取工程路径：--%>
${pageContext.request.contextPath}<br />
<%--5. 获取请求方法：--%>
${pageContext.request.method}<br />
<%--6. 获取客户端 ip 地址：--%>
${pageContext.request.remoteHost}<br />
<%--7. 获取会话的 id 编号--%>
${pageContext.session.id}


</body>
</html>
