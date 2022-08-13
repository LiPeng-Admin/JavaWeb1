<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.getWriter().println("response1输出<br/>");
    response.getWriter().println("response2输出<br/>");

    out.write("out 输出1<br/>");
    out.write("out 输出2<br/>");

%>

</body>
</html>
