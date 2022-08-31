package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: 免用户名登录的实现
 * @date 2022/8/30 22:42
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("wzg168".equalsIgnoreCase(username) &&"123456".equalsIgnoreCase(password)) {
           //登录成功
            Cookie cookie = new Cookie("username", username);
            //设置Cookie 存活时间:7天
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            System.out.println("登录成功");

        }else{
            //登录失败
            System.out.println("登陆失败");
        }
    }
}
