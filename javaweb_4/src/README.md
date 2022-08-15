1.EL 表达式
a)什么是 EL 表达式，EL 表达式的作用?
EL 表达式的全称是：Expression Language。是表达式语言。
EL 表达式的什么作用：EL 表达式主要是代替 jsp 页面中的表达式脚本在 jsp 页面中进行数据的输出。
因为 EL 表达式在输出数据的时候，要比 jsp 的表达式脚本要简洁很多。

    EL 表达式的格式是：${表达式}
    EL 表达式在输出 null 值的时候，输出的是空串。jsp 表达式脚本输出 null 值的时候，输出的是 null 字符串。

EL 表达式主要是在 jsp 页面中输出数据。
主要是输出域对象中的数据。
当四个域中都有相同的 key 的数据的时候，EL 表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。

EL 表达式——运算
语法：${ 运算表达式 } ， EL 表达式支持如下运算符：
1）关系运算
关系运算符 说 明 范 例 结果
    == 或 eq 等于 ${ 5 == 5 } 或 ${ 5 eq 5 } true
    != 或 ne 不等于 ${ 5 !=5 } 或 ${ 5 ne 5 } false
    < 或 lt 小于 ${ 3 < 5 } 或 ${ 3 lt 5 } true
    > 或 gt 大于 ${ 2 > 10 } 或 ${ 2 gt 10 } false
    <= 或 le 小于等于 ${ 5 <= 12 } 或 ${ 5 le 12 } true
    >= 或 ge 大于等于 ${ 3 >= 5 } 或 ${ 3 ge 5 } false
2）逻辑运算
逻辑运算符 说 明 范 例 结果
    && 或 and 与运算 ${ 12 == 12 && 12 < 11 } 或 ${ 12 == 12 and 12 < 11 } false
    || 或 or 或运算 ${ 12 == 12 || 12 < 11 } 或 ${ 12 == 12 or 12 < 11 } true
    ! 或 not 取反运算 ${ !true } 或 ${not true } false
3）算数运算
算数运算符 说 明 范 例 结果
+ 加法 ${ 12 + 18 } 30
  - 减法 ${ 18 - 8 } 10
  * 乘法 ${ 12 * 12 } 144
    / 或 div 除法 ${ 144 / 12 } 或 ${ 144 div 12 } 12
    % 或 mod 取模 ${ 144 % 10 } 或 ${ 144 mod 10 } 4
4）empty 运算
    empty 运算可以判断一个数据是否为空，如果为空，则输出 true,不为空输出 false。
    以下几种情况为空：
    1、值为 null 值的时候，为空
    2、值为空串的时候，为空
    3、值是 Object 类型数组，长度为零的时候
    4、list 集合，元素个数为零
    5、map 集合，元素个数为零
        <body>
        <%
        // 1、值为 null 值的时候，为空
        request.setAttribute("emptyNull", null);
        // 2、值为空串的时候，为空
        request.setAttribute("emptyStr", "");
        // 3、值是 Object 类型数组，长度为零的时候
        request.setAttribute("emptyArr", new Object[]{});
        // 4、list 集合，元素个数为零
        List<String> list = new ArrayList<>();
        // list.add("abc");
        request.setAttribute("emptyList", list);
        // 5、map 集合，元素个数为零
        Map<String,Object> map = new HashMap<String, Object>();
        // map.put("key1", "value1");
        request.setAttribute("emptyMap", map);
        %>
        ${ empty emptyNull } <br/>
        ${ empty emptyStr } <br/>
        ${ empty emptyArr } <br/>
        ${ empty emptyList } <br/>
        ${ empty emptyMap } <br/>
        </body>

ii. 三元运算
表达式 1？表达式 2：表达式 3
如果表达式 1 的值为真，返回表达式 2 的值，如果表达式 1 的值为假，返回表达式 3 的值。

iii. “.”点运算 和 [] 中括号运算符
.点运算，可以输出 Bean 对象中某个属性的值。
[]中括号运算，可以输出有序集合中某个元素的值。
并且[]中括号运算，还可以输出 map 集合中 key 里含有特殊字符的 key 的值。


EL 表达式的 11 个隐含对象
    EL 个达式中 11 个隐含对象，是 EL 表达式中自己定义的，可以直接使用。
    变量 类型 作用
    pageContext PageContextImpl 它可以获取 jsp 中的九大内置对象
    pageScope Map<String,Object> 它可以获取 pageContext 域中的数据
    requestScope Map<String,Object> 它可以获取 Request 域中的数据
    sessionScope Map<String,Object> 它可以获取 Session 域中的数据
    applicationScope Map<String,Object> 它可以获取 ServletContext 域中的数据
    param Map<String,String> 它可以获取请求参数的值
    paramValues Map<String,String[]> 它也可以获取请求参数的值，获取多个值的时候使用。
    header Map<String,String> 它可以获取请求头的信息
    headerValues Map<String,String[]> 它可以获取请求头的信息，它可以获取多个值的情况
    cookie Map<String,Cookie> 它可以获取当前请求的 Cookie 信息
    initParam Map<String,String> 它可以获取在 web.xml 中配置的<context-param>上下文参数

i. EL 获取四个特定域中的属性
pageScope ====== pageContext 域
requestScope ====== Request 域
sessionScope ====== Session 域
applicationScope ====== ServletContext 域

ii. pageContext 对象的使用
1. 协议：
2. 服务器 ip：
3. 服务器端口：
4. 获取工程路径：
5. 获取请求方法：
6. 获取客户端 ip 地址：
7. 获取会话的 id 编号：
 
 iii. EL 表达式其他隐含对象的使用
   param Map<String,String> 它可以获取请求参数的值
   paramValues Map<String,String[]> 它也可以获取请求参数的值，获取多个值的时候使用。
   示例代码：
   输出请求参数 username 的值：${ param.username } <br>
   输出请求参数 password 的值：${ param.password } <br>
   输出请求参数 username 的值：${ paramValues.username[0] } <br>
   输出请求参数 hobby 的值：${ paramValues.hobby[0] } <br>
   输出请求参数 hobby 的值：${ paramValues.hobby[1] } <br>
   请求地址：
   http://localhost:8080/09_EL_JSTL/other_el_obj.jsp?username=wzg168&password=666666&hobby=java&hobby=cpp
   header Map<String,String> 它可以获取请求头的信息
   headerValues Map<String,String[]> 它可以获取请求头的信息，它可以获取多个值的情况
   示例代码：
   输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
   输出请求头【Connection】的值：${ header.Connection } <br>
   输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br>
   cookie Map<String,Cookie> 它可以获取当前请求的 Cookie 信息
   示例代码：
   获取 Cookie 的名称：${ cookie.JSESSIONID.name } <br>
   获取 Cookie 的值：${ cookie.JSESSIONID.value } <br>
   initParam Map<String,String> 它可以获取在 web.xml 中配置的<context-param>上下文参数


JSTL 标签库 
    全称是指 JSP Standard Tag Library JSP 标准标签库。是一个不断完善的开放源代码的 JSP 标
    签库。
    EL 表达式主要是为了替换 jsp 中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个 jsp 页面
    变得更佳简洁。

 JSTL 标签库的使用步骤
    1、先导入 jstl 标签库的 jar 包。
    taglibs-standard-impl-1.2.1.jar
    taglibs-standard-spec-1.2.1.jar
    2、第二步，使用 taglib 指令引入标签库。
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

core 核心库使用
i. <c:set />（使用很少）
作用：set 标签可以往域中保存数据
ii. <c:if />
if 标签用来做 if 判断。

iii. <c:choose> <c:when> <c:otherwise>标签
作用：多路判断。跟 switch ... case .... default 非常接近
<c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
    1、标签里不能使用 html 注释，要使用 jsp 注释
    2、when 标签的父标签一定要是 choose 标签


iv. <c:forEach />
作用：遍历输出使用。

文件的上传和下载
文件的上传
1、要有一个 form 标签，method=post 请求
2、form 标签的 encType 属性值必须为 multipart/form-data 值
3、在 form 标签中使用 input type=file 添加上传的文件
4、编写服务器代码（Servlet 程序）接收，处理上传的数据

encType=multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼
接，然后以二进制流的形式发送给服务器

1.1文件上传，HTTP 协议的说明

1.2、commons-fileupload.jar 常用 API 介绍说明
commons-fileupload.jar 需要依赖 commons-io.jar 这个包，所以两个包我们都要引入。
第一步，就是需要导入两个 jar 包：
commons-fileupload-1.2.1.jar
commons-io-1.4.jar
commons-fileupload.jar 和 commons-io.jar 包中，我们常用的类有哪些？
ServletFileUpload 类，用于解析上传的数据。
FileItem 类，表示每一个表单项。
boolean ServletFileUpload.isMultipartContent(HttpServletRequest request);
判断当前上传的数据格式是否是多段的格式。
public List<FileItem> parseRequest(HttpServletRequest request)
解析上传的数据
boolean FileItem.isFormField()
判断当前这个表单项，是否是普通的表单项。还是上传的文件类型。
true 表示普通类型的表单项
false 表示上传的文件类型
String FileItem.getFieldName()
获取表单项的 name 属性值
String FileItem.getString()
获取当前表单项的值。
String FileItem.getName();
获取上传的文件名
void FileItem.write( file );
将上传的文件写到 参数 file 所指向抽硬盘位置 。

文件下载
下载的常用 API 说明：
response.getOutputStream();
servletContext.getResourceAsStream();
servletContext.getMimeType();
response.setContentType();
response.setHeader("Content-Disposition", "attachment; fileName=1.jpg");
这个响应头告诉浏览器。这是需要下载的。而 attachment 表示附件，也就是下载的一个文件。fileName=后面，
表示下载的文件名。
完成上面的两个步骤，下载文件是没问题了。但是如果我们要下载的文件是中文名的话。你会发现，下载无法正确
显示出正确的中文名。
原因是在响应头中，不能包含有中文字符，只能包含 ASCII

附件中文名乱码问题解决方案：
方案一：URLEncoder 解决 IE 和谷歌浏览器的 附件中
文名问题。
如果客户端浏览器是 IE 浏览器 或者 是谷歌浏览器。我们需要使用 URLEncoder 类先对中文名进行 UTF-8 的编码
操作。
因为 IE 浏览器和谷歌浏览器收到含有编码后的字符串后会以 UTF-8 字符集进行解码显示。
// 把中文名进行 UTF-8 编码操作。
String str = "attachment; fileName=" + URLEncoder.encode("中文.jpg", "UTF-8");
// 然后把编码后的字符串设置到响应头中
response.setHeader("Content-Disposition", str);
方案二：BASE64 编解码 解决 火狐浏览器的附件中文名问
题
如果客户端浏览器是火狐浏览器。 那么我们需要对中文名进行 BASE64 的编码操作。
这时候需要把请求头 Content-Disposition: attachment; filename=中文名
编码成为：Content-Disposition: attachment; filename==?charset?B?xxxxx?=
=?charset?B?xxxxx?= 现在我们对这段内容进行一下说明。
=? 表示编码内容的开始
charset 表示字符集
B 表示 BASE64 编码
xxxx 表示文件名 BASE64 编码后的内容
?= 表示编码内容的结束
BASE64 编解码操作：
public static void main(String[] args) throws Exception 
