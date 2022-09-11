Filter 的生命周期包含几个方法
1、构造器方法
2、init 初始化方法
第 1，2 步，在 web 工程启动的时候执行（Filter 已经创建）
3、doFilter 过滤方法
第 3 步，每次拦截到请求，就会执行
4、destroy 销毁
第 4 步，停止 web 工程的时候，就会执行（停止 web 工程，也会销毁 Filter

FilterConfig 类
FilterConfig 类见名知义，它是 Filter 过滤器的配置文件类。
Tomcat 每次创建 Filter 的时候，也会同时创建一个 FilterConfig 类，这里包含了 Filter 配置文件的配置信息。
FilterConfig 类的作用是获取 filter 过滤器的配置内容
1、获取 Filter 的名称 filter-name 的内容
2、获取在 Filter 中配置的 init-param 初始化参数
3、获取 ServletContext 对象

Filter 的拦截路径
--精确匹配
    <url-pattern>/target.jsp</url-pattern>
    以上配置的路径，表示请求地址必须为：http://ip:port/工程路径/target.jsp
--目录匹配
    <url-pattern>/admin/*</url-pattern>
    以上配置的路径，表示请求地址必须为：http://ip:port/工程路径/admin/* 
--后缀名匹配
    <url-pattern>*.html</url-pattern>
    以上配置的路径，表示请求地址必须以.html 结尾才会拦截到
    <url-pattern>*.do</url-pattern>
    以上配置的路径，表示请求地址必须以.do 结尾才会拦截到
    <url-pattern>*.action</url-pattern>
    以上配置的路径，表示请求地址必须以.action 结尾才会拦截到
    Filter 过滤器它只关心请求的地址是否匹配，不关心请求的资源是否存在！！

ThreadLocal 的作用，它可以解决多线程的数据安全问题。
ThreadLocal 它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数组，集合）
ThreadLocal 的特点：
1、ThreadLocal 可以为当前线程关联一个数据。（它可以像 Map 一样存取数据，key 为当前线程）
2、每一个 ThreadLocal 对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个
ThreadLocal 对象实例。
3、每个 ThreadLocal 对象实例定义的时候，一般都是 static 类型
4、ThreadLocal 中保存数据，在线程销毁后。会由 JVM 虚拟自动释放

使用 Filter 和 ThreadLocal 组合管理事务
   使用 ThreadLocal 来确保所有 dao 操作都在同一个 Connection 连接对象中完成
   使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch。来进行实现的管理
   将所有异常都统一交给 Tomcat，让 Tomcat 展示友好的错误信息页面
      在 web.xml 中我们可以通过错误页面配置来进行管理
