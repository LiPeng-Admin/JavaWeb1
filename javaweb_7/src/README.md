json
是由键值对组成，并且由花括号（大括号）包围。每个键由引号引起来，键和值之间使用冒号进行分隔，
多组键值对之间进行逗号进行分隔。


json 的存在有两种形式。
一种是：对象的形式存在，我们叫它 json 对象。
一种是：字符串的形式存在，我们叫它 json 字符串。
一般我们要操作 json 中的数据的时候，需要 json 对象的格式。
一般我们要在客户端和服务器之间进行数据交换的时候，使用 json 字符串。
JSON.stringify() 把 json 对象转换成为 json 字符串
JSON.parse() 把 json 字符串转换成为 json 对象

JSON 在 java 中的使用
    javaBean 和 json 的互转
    List 和 json 的互转
    map 和 json 的互转

AJAX
ajax 是一种浏览器通过 js 异步发起请求，局部更新页面的技术。


jQuery 中的 AJAX 请求
    $.ajax 方法
    url 表示请求的地址
    type 表示请求的类型 GET 或 POST 请求
    data 表示发送给服务器的数据
    格式有两种：
    一：name=value&name=value
    二：{key:value}
    success 请求成功，响应的回调函数
    dataType 响应的数据类型
    常用的数据类型有：
    text 表示纯文本
    xml 表示 xml 数据
    json 表示 json 对

    $.get 方法和$.post 方法
    url 请求的 url 地址
    data 发送的数据
    callback 成功的回调函数
    type 返回的数据类型

    $.get 方法和$.post 方法
    url 请求的 url 地址
    data 发送的数据
    callback 成功的回调函数
    type 返回的数据类型



    $.getJSON 方法
    url 请求的 url 地址
    data 发送给服务器的数据
    callback 成功的回调函数


    表单序列化 serialize()
    serialize()可以把表单中所有表单项的内容都获取到，并以 name=value&name=value