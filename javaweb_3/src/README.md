1.什么是 jsp，它有什么用? jsp 的全换是 java server pages。Java 的服务器页面。 jsp 的主要作用是代替 Servlet 程序回传 html 页面的数据。 因为 Servlet 程序回传 html
页面数据是一件非常繁锁的事情。开发成本和维护成本都极高。

2、jsp 如何访问： jsp 页面和 html 页面一样，都是存放在 web 目录下。访问也跟访问 html 页面一样。 比如： 在 web 目录下有如下的文件： web 目录 a.html 页面 访问地址是
=======>>>>>> http://ip:port/工程路径/a.html b.jsp 页面 访问地址是 =======>>>>>> http://ip:port/工程路径/b.jsp

3:jsp 的本质是什么。 jsp 页面本质上是一个 Servlet 程序。

4:jsp 的三种语法 1）jsp 头部的 page 指令 jsp 的 page 指令可以修改 jsp 页面中一些重要的属性，或者行为。

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    i. language 属性 表示 jsp 翻译后是什么语言文件。暂时只支持 java。
    ii. contentType 属性 表示 jsp 返回的数据类型是什么。也是源码中 response.setContentType()参数值
    iii. pageEncoding 属性 表示当前 jsp 页面文件本身的字符集。
    iv. import 属性 跟 java 源代码中一样。用于导包，导类。

    ========================两个属性是给 out 输出流使用=============================
    v. autoFlush 属性 设置当 out 输出流缓冲区满了之后，是否自动刷新冲级区。默认值是 true。
    vi. buffer 属性 设置 out 缓冲区的大小。默认是 8kb

========================两个属性是给 out 输出流使用============================= vii. errorPage 属性 设置当 jsp 页面运行时出错，自动跳转去的错误页面路径。
viii. isErrorPage 属性 设置当前 jsp 页面是否是错误信息页面。默认是 false。如果是 true 可以 获取异常信息。 ix. session 属性 设置访问当前 jsp 页面，是否会创建 HttpSession
对象。默认是 true。 x. extends 属性 设置 jsp 翻译出来的 java 类默认继承谁。

2)jsp 中的常用脚本 i. 声明脚本(极少使用)
声明脚本的格式是： <%! 声明 java 代码 %>
作用：可以给 jsp 翻译出来的 java 类定义属性和方法甚至是静态代码块。内部类等。 练习： 1、声明类属性 2、声明 static 静态代码块 3、声明类方法 4、声明内部类

ii. 表达式脚本（常用） 表达式脚本的格式是：<%=表达式%>
表达式脚本的作用是：的 jsp 页面上输出数据。 表达式脚本的特点： 1、所有的表达式脚本都会被翻译到_jspService() 方法中 2、表达式脚本都会被翻译成为 out.print()输出到页面上 3、由于表达式脚本翻译的内容都在_
jspService() 方法中,所以_jspService()方法中的对象都可以直接使用。 4、表达式脚本中的表达式不能以分号结束。 练习：

1. 输出整型
    1. 输出浮点型
    2. 输出字符串
    3. 输出对象

iii. 代码脚本 代码脚本的格式是：
<% java 语句 %>
代码脚本的作用是：可以在 jsp 页面中，编写我们自己需要的功能（写的是 java 语句）。 代码脚本的特点是： 1、代码脚本翻译之后都在_jspService 方法中 2、代码脚本由于翻译到_jspService()方法中，所以在_
jspService()方法中的现有对象都可以直接使用。 3、还可以由多个代码脚本块组合完成一个完整的 java 语句。 4、代码脚本还可以和表达式脚本一起组合使用，在 jsp 页面上输出数据 练习：

2. 代码脚本----if 语句
3. 代码脚本----for 循环语句
4. 翻译后 java 文件中_jspService 方法内的代码都可以写

3)jsp 中的三种注释

i. html 注释
<!-- 这是 html 注释 -->
html 注释会被翻译到 java 源代码中。在_jspService 方法里，以 out.writer 输出到客户端。

ii. java 注释
<% // 单行 java 注释 /* 多行 java 注释 */ %>
java 注释会被翻译到 java 源代码中。

iii. jsp 注释
<%-- 这是 jsp 注释 --%>
jsp 注释可以注掉，jsp 页面中所有代码

4)jsp 九大内置对象 request 请求对象 response 响应对象 pageContext jsp 的上下文对象 session 会话对象 application ServletContext 对象 config
ServletConfig 对象 out jsp输出流对象 page 指向当前jsp 的对象 exception 异常对象

5）jsp 四大域对象 四个域对象分别是： pageContext (PageContextImpl 类) 当前 jsp 页面范围内有效 request (HttpServletRequest 类)、 一次请求内有效 session (
HttpSession 类)、 一个会话范围内有效（打开浏览器访问服务器，直到关闭浏览器） application (ServletContext 类) 整个 web 工程范围内都有效（只要 web 工程不停止，数据都在） 域对象是可以像
Map 一样存取数据的对象。四个域对象功能一样。不同的是它们对数据的存取范围。 虽然四个域对象都可以存取数据。在使用上它们是有优先顺序的。 四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序。 pageContext
====>>> request ====>>> session ====>>>

6)jsp 中的 out 输出和 response.getWriter 输出的区别

response 中表示响应，我们经常用于设置返回给客户端的内容（输出） out 也是给用户做输出使用的 由于 jsp 翻译之后，底层源代码都是使用 out 来进行输出，所以一般情况下。我们在 jsp 页面中统一使用 out 来进行输出。避
免打乱页面输出内容的顺序。 out.write() 输出字符串没有问题 out.print() 输出任意数据都没有问题（都转换成为字符串后调用的 write 输出） 深入源码，浅出结论：在 jsp 页面中，可以统一使用
out.print()来进行输出

7.jsp 的常用标签 a)jsp 静态包含 示例说明：
<%--
<%@ include file=""%> 就是静态包含 file 属性指定你要包含的 jsp 页面的路径 地址中第一个斜杠 / 表示为 http://ip:port/工程路径/ 映射到代码的 web 目录 静态包含的特点：
1、静态包含不会翻译被包含的 jsp 页面。 2、静态包含其实是把被包含的 jsp 页面的代码拷贝到包含的位置执行输出。 --%>
<%@ include file="/include/footer.jsp"%>
b)jsp 动态包含 示例说明：
<%--
<jsp:include page=""></jsp:include> 这是动态包含 page 属性是指定你要包含的 jsp 页面的路径 动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置 动态包含的特点：
1、动态包含会把包含的 jsp 页面也翻译成为 java 代码 2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。 JspRuntimeLibrary.include(request, response, "
/include/footer.jsp", out, false); 3、动态包含，还可以传递参数 --%>
<jsp:include page="/include/footer.jsp">
<jsp:param name="username" value="bbj"/>
<jsp:param name="password" value="root"/>
</jsp:include>

c)jsp 标签-转发 示例说明：
<%--
<jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发 page 属性设置请求转发的路径 --%>
<jsp:forward page="/scope2.jsp"></jsp:forward>

9、什么是 Listener 监听器？ 1、Listener 监听器它是 JavaWeb 的三大组件之一。JavaWeb 的三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监 听器。 2、Listener 它是
JavaEE 的规范，就是接口 3、监听器的作用是，监听某种事物的变化。然后通过回调函数，反馈给客户（程序）去做一些相应的处理

9.1、ServletContextListener 监听器 ServletContextListener 它可以监听 ServletContext 对象的创建和销毁。 ServletContext 对象在 web 工程启动的时候创建，在
web 工程停止的时候销毁。 监听到创建和销毁之后都会分别调用 ServletContextListener 监听器的方法反馈。 两个方法分别是： public interface ServletContextListener
extends EventListener { /**

* 在 ServletContext 对象创建之后马上调用，做初始化
  */ public void contextInitialized(ServletContextEvent sce); /**
* 在 ServletContext 对象销毁之后调用
  */ public void contextDestroyed(ServletContextEvent sce); } 如何使用 ServletContextListener 监听器监听 ServletContext 对象。
  使用步骤如下： 1、编写一个类去实现 ServletContextListener 2、实现其两个回调方法 3、到 web.xml 中去配置监听器 监听器实现类： public class
  MyServletContextListenerImpl implements ServletContextListener { @Override public void contextInitialized(
  ServletContextEvent sce) { System.out.println("ServletContext 对象被创建了"); } @Override public void contextDestroyed(
  ServletContextEvent sce) { System.out.println("ServletContext 对象被销毁了"); } } web.xml 中的配置：

<!--配置监听器-->
<listener>
<listener-class>com.atguigu.listener.MyServletContextListenerImpl</listener-class>
</listener>

