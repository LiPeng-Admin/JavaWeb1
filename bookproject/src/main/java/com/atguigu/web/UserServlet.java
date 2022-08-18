package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/17 21:48
 */
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1：获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2:调用UserService 处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于 null,说明登陆失败，
        if (loginUser == null) {
            System.out.println("success false");
            //把错误信息，和回显 的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳回到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            System.out.println("success true");
            //登录成功，页面跳转到登录成功页
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);


        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //3、检查 用户名是否可用
            if (userService.existsUsername(username)) {


                System.out.println("用户名" + username + "已存在");
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);


            } else {
//               调用Sservice保存到数据库
                userService.registerUser(new User(null, username, password, email));
                //        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }
        } else {
            //把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误!!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //验证码不正确
            System.out.println("验证码错误" + code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("action");
//        if ("login".equals(parameter)) {
//            login(req, resp);
//
//
//        } else if ("regist".equals(parameter)) {
//            regist(req, resp);
//
//
//        }
        //代码优化
        try {
            //通过action 业务   鉴别字符串，获取相应的业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(parameter, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法

            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
