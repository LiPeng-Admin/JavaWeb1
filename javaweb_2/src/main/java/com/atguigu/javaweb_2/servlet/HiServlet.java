package com.atguigu.javaweb_2.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求和响应的
     */
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
