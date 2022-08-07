package com.atguigu.javaweb_2.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ServletContext context =  getServletContext();
        System.out.println(context);
        System.out.println("保存之前Context1中获取域数据的值为："+context.getAttribute("key"));
       context.setAttribute("key","value");
        System.out.println("Context1 中获取域数据的值是："+context.getAttribute("key"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
