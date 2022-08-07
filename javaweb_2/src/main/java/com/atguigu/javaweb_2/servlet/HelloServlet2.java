package com.atguigu.javaweb_2.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description:
 * 继承 HttpServlet 实现 Servlet 程序
     * 一般在实际项目开发中，都是使用继承 HttpServlet 类的方式去实现 Servlet 程序。
     * 1、编写一个类去继承 HttpServlet 类
     * 2、根据业务需要重写 doGet 或 doPost 方法
     * 3、到 web.xml 中的配置 Servlet 程序的访问地
 * @date 2022/8/7 13:48
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init初始化方法，做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello servlet2 doGet 请求 " );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello servlet2 doPost 请求 " );
    }
}
