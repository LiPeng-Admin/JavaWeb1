package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lipeng
 * @version 1.0
 * @description: 表单重复提交

 * 表单重复提交有三种常见的情况：
 * 一：提交完表单。服务器使用请求转来进行页面跳转。这个时候，用户按下功能键 F5，就会发起最后一次的请求。
 * 造成表单重复提交问题。解决方法：使用重定向来进行跳转
 * 二：用户正常提交服务器，但是由于网络延迟等原因，迟迟未收到服务器的响应，这个时候，用户以为提交失败，
 * 就会着急，然后多点了几次提交操作，也会造成表单重复提交。
 * 三：用户正常提交服务器。服务器也没有延迟，但是提交完成后，用户回退浏览器。重新提交。也会造成表单重复提交
 *
 *
 二，三 解决表单重复提交的方法：使用验证吗

 * @date 2022/9/3 9:52
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //2:删除session 中的验证码，阻止表单重复提交
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //3:获取表单提交的code 请求参数
        String code = req.getParameter("code");
        //获取用户名
        String username = req.getParameter("username");

        //判断验证码是否一致
        if (token != null && token.equalsIgnoreCase(code)) {
            //1：使用请求转发会导致表单重复提交
//        req.getRequestDispatcher("/register_success.jsp").forward(req, resp);

            //2:网络延迟等方式
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println("保存到数据库" + username);
            resp.sendRedirect(req.getContextPath() + "/register_success.jsp");
        } else {
            System.out.println("表单重复提交");
        }


    }
}
