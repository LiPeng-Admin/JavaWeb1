package com.atguigu.javaweb_2.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 手动实现 Servlet 程序
 * 1、编写一个类去实现 Servlet 接口
 * 2、实现 service 方法，处理请求，并响应数据
 * 3、到 web.xml 中去配置 servlet 程序的访问地址
 */

/**
 * servlet 的生命周期
 * <p>
 * 1:执行servlet构造器方法
 * 2：执行init初始化方法
 * 1,2步 是在第一次访问的时候创建servlet程序被调用
 * <p>
 * 3：执行service 方法
 * 每次访问的时候都会被调用
 * <p>
 * 4：执行destroy销毁方法
 * web工程停止 的时候被调用
 */

public class HiServlet implements Servlet {
    public HiServlet() {
        System.out.println("1：构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2：初始化方法");
/*   ServletConfig 作用

    1、可以获取 Servlet 程序的别名 servlet-name 的值
    2、获取初始化参数 init-param
    3、获取 ServletContext

    Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。
    Servlet 程序默认是第一次访问的时候创建，
    ServletConfig 是每个 Servlet 程序创建时，就创建一个对应的 ServletConfig 对象

*
* */
        //1.可以获取servlet 程序别名servlet-name的值
        System.out.println(servletConfig.getServletName());
        //2：获取初始化参数init-param
        System.out.println("初始化参数username 的值是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+servletConfig.getInitParameter("url"));

       //3:获取 ServletContext
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求和响应的
     */
    /**
     * GET 和 POST 请求的分发处理
     *
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3：servlet程序被访问了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }


    }

    /*
     *
     * get请求操作
     * */
    public void doGet() {
        System.out.println("get请求");
    }

    /*
     *
     * post请求操作
     * */
    public void doPost() {
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4：destroy销毁方法");

    }
}
