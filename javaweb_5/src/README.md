谷歌 kaptcha 图片验证码的使用
谷歌验证码 kaptcha 使用步骤如下：
1、导入谷歌验证码的 jar 包
kaptcha-2.3.2.jar

2、在 web.xml 中去配置用于生成验证码的 Servlet 程序
<servlet>
<servlet-name>KaptchaServlet</servlet-name>
<servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>KaptchaServlet</servlet-name>
<url-pattern>/kaptcha.jpg</url-pattern>
</servlet-mapping>
3、在表单中使用 img 标签去显示验证码图片并使用

<form action="http://localhost:8080/tmp/registServlet" method="get">
用户名：<input type="text" name="username" > <br>
验证码：<input type="text" style="width: 80px;" name="code">
<img src="http://localhost:8080/tmp/kaptcha.jpg" alt="" style="width: 100px; height: 28px;"> <br>
<input type="submit" value="登录">
</form>

4、在服务器获取谷歌生成的验证码和客户端发送过来的验证码比较使用

// 获取 Session 中的验证码
String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
// 删除 Session 中的验证码
req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
String code = req.getParameter("code");
// 获取用户名
String username = req.getParameter("username");
if (token != null && token.equalsIgnoreCase(code)) {
System.out.println("保存到数据库：" + username);
resp.sendRedirect(req.getContextPath() + "/ok.jsp");
} else {
System.out.println("请不要重复提交表单");
}