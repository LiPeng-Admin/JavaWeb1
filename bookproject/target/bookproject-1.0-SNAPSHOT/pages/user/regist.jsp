<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--    静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>

    <script type="text/javascript">
        /*
        需求：
        验证用户名：必须是字母，数字，下划线，并且长度是5-12位
        验证密码：必须是字母，数字，下划线，并且长度是5-12位
        验证确认密码：和密码相同
        邮箱验证：xxxx@xxx.com
        验证码：现在只需要验证用户已输入，
          *
          *
          * */
        //页面加载完成之后
        $(function () {
            $("#username").blur(function () {
                //1：获取用户名
                var username = this.value;
                $.getJSON("http://localhost:8080/bookproject/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
                    // console.log(data)
                    if(data.existsUsername){
                        $("span.errorMsg").text("用户名已存在！");

                    }else{
                        $("span.errorMsg").text("用户名可用");
                    }

                })
            })


            //给注册绑定单击事件
            /*验证用户名：必须是字母，数字，下划线，并且长度是5-12位
            * 1:获取用户名输入框里面的内容
            * 2：创建正则表达式对象
            * 3：使用test方法验证
            * 4：提示用户结果
            *
            *
            * */
            $("#sub_btn").click(function () {
                // 1:获取用户名输入框里面的内容
                const usernameText = $("#username").val();
                //2：创建正则表达式对象
                const usernamePatt = /^\w{5,12}$/;
                // 3：使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4：提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;

                }
                $("span.errorMsg").text("")

                // 验证密码：必须是字母，数字，下划线，并且长度是5-12位
                // 1:获取用户名输入框里面的内容
                const passwordText = $("#password").val();
                //2：创建正则表达式对象
                const passwordPatt = /^\w{5,12}$/;
                // 3：使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4：提示用户结果
                    $("span.errorMsg").text("输入的密码不合法！");

                    return false;

                }
                $("span.errorMsg").text("")

                //验证确认密码：和密码相同
                //1:获取确认密码内容
                const repwdText = $("#repwd").val();

                //2:判断输入密码与确认密码是否相同
                if (repwdText != passwordText) {
                    //3:提示用户
                    $("span.errorMsg").text("确认密码与密码不同！")
                    return false;

                }
                $("span.errorMsg").text("")

                //邮箱验证：xxxx@xxx.com
                //1:获取邮箱内容
                const emailText = $("#email").val();
                //2:使用正则表达式创建对象
                const emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                // 3：使用test方法验证
                if (!emailPatt.test(emailText)) {
                    // * 4：提示用户结果
                    $("span.errorMsg").text("邮箱格式不正确，请重新输入");
                    return false;

                }
                $("span.errorMsg").text("");

                // 验证码：现在只需要验证用户已输入，


                const codeText = $("#code").val();

                //去掉验证码前后空格
                $.trim(codeText)
                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码不正确")
                    return false;
                }
                $("span.errorMsg").text("")


            })
            //给验证码图片绑定单击事件

            $("#code_img").click(function () {
                //在事件响应的function函数中，有一个this 对象，这个this对象，是当前正在响应的dom 对象
                //src 属性表示验证码img 标签的图片路径，可读，可写
                //new Date():为了解决浏览器端的缓存问题
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();

            })


        })
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">

<%--                           <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>;--%>
                        ${requestScope.msg}

                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                        <%--                               value="<%=request.getAttribute("username")==null ? "" : request.getAttribute("username") %>"/>--%>
                               value="${requestScope.username}"
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                        <%--                               value="<%=request.getAttribute("email")==null?"" : request.getAttribute("email")%>"/>--%>
                               value="${requestScope.email}"
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
                        <img alt="" id="code_img" src="kaptcha.jpg" style="float: right; margin-right: 40px" width="110"
                             height="30">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>