package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 11:43
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置发送到客户端的响应的内容类型
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("wzg168".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().println("登录成功");

        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
