<%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/14
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--param Map<String,String> 它可以获取请求参数的值--%>
<%--paramValues Map<String,String[]> 它也可以获取请求参数的值，获取多个值的时候使用。--%>
输出请求参数 username 的值：${ param.username } <br>
输出请求参数 password 的值：${ param.password } <br>
输出请求参数 username 的值：${ paramValues.username[0] } <br>
输出请求参数 hobby 的值：${ paramValues.hobby[0] } <br>
输出请求参数 hobby 的值：${ paramValues.hobby[1] } <br>

<%--
 header Map<String,String> 它可以获取请求头的信息
 headerValues Map<String,String[]> 它可以获取请求头的信息，它可以获取多个值的情况
   --%>
输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
输出请求头【Connection】的值：${ header.Connection } <br>
输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br>

<%--
cookie Map<String,Cookie> 它可以获取当前请求的 Cookie 信息
--%>
获取 Cookie 的名称：${ cookie.JSESSIONID.name } <br>
获取 Cookie 的值：${ cookie.JSESSIONID.value } <br>

<%--
 initParam Map<String,String> 它可以获取在 web.xml 中配置的<context-param>上下文参数
--%>
${ initParam.username } <br>
${ initParam.url } <br>

</body>
</html>
