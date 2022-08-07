package com.atguigu.javaweb_2.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * ServletContext是什么？
     * 1、ServletContext 是一个接口，它表示 Servlet 上下文对象
     * 2、一个 web 工程，只有一个 ServletContext 对象实例。
     * 3、ServletContext 对象是一个域对象。
     * 4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。
 * 什么是域对象?
     * 域对象，是可以像 Map 一样存取数据的对象，叫域对象。
     * 这里的域指的是存取数据的操作范围，整个 web 工程。
 *
 *       存数据            取数据          删除 数据
 * Map   put()            get()          remove()
 * 域对象 setAttribute() getAttribute() removeAttribute();
 *
 * ServletContext 类的四个作用
     * 1、获取 web.xml 中配置的上下文参数 context-param
     * 2、获取当前的工程路径，格式: /工程路径
     * 3、获取工程部署后在服务器硬盘上的绝对路径
     * 4、像 Map 一样存取数据
 *
 *
 * */

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        *  1、获取 web.xml 中配置的上下文参数 context-param
           2、获取当前的工程路径，格式: /工程路径
         * 3、获取工程部署后在服务器硬盘上的绝对路径
         * 4、像 Map 一样存取数据
        *
        * */



        //1、获取 web.xml 中配置的上下文参数 context-param
        System.out.println(getServletContext().getInitParameter("username"));
        System.out.println(getServletContext().getInitParameter("password"));
//        2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径是："+getServletContext().getContextPath());
        //3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径是："+getServletContext().getRealPath("/"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
