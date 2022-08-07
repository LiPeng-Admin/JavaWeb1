package com.atguigu.javaweb_2.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 20:14
 */

/*
* HttpServletRequest的作用
    * 每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Request对象中。
    * 然后传递到service方法（doGet和doPost）中给我们使用。我们可以通过HttpServletRequest对象，获取到所有请求的信息。
*
* HttpServletRequest类的常用方法
    * i.getRequestURI()获取请求的资源路径
    * ii.getRequestURL()获取请求的统一资源定位符（绝对路径）
    * iii.getRemoteHost()获取客户端的ip地址
    * iv.getHeader()获取请求头v.getParameter()获取请求的参数
    * vi.getParameterValues()获取请求的参数（多个值的时候使用）
    * vii.getMethod()获取请求的方式GET或POST
    * viii.setAttribute(key,value);设置域数据
    * ix.getAttribute(key);获取域数据
    * x.getRequestDispatcher()获取请求转发对象
*
* */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        super.doGet(req, resp);
        System.out.println("请求的URI是："+req.getRequestURI());
        System.out.println("请求的URL是："+req.getRequestURL());
        System.out.println("客户端ip 地址："+req.getRemoteHost());
        System.out.println("请求头User-Agent"+req.getHeader("User-Agent"));
        System.out.println("获取的请求方式："+req.getMethod());

    }
}
