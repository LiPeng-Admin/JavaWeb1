package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 10:03
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//1：获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2:调用UserService 处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于 null,说明登陆失败，
        if(loginUser== null){
            System.out.println("success false");
            //把错误信息，和回显 的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            //登录成功
            System.out.println("success true");
            //登录成功，页面跳转到登录成功页
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);



        }

    }
}
