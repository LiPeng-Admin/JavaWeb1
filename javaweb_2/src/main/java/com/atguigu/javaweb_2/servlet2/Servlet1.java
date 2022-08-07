package com.atguigu.javaweb_2.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Web 中的相对路径和绝对路径
 * 在 javaWeb 中，路径分为相对路径和绝对路径两种：
 * 相对路径是：
 * . 表示当前目录
 * .. 表示上一级目录
 * 资源名 表示当前目录/资源名
 * 绝对路径：
 * http://ip:port/工程路径/资源路径
 * 在实际开发中，路径都使用绝对路径，而不简单的使用相对路径。
 * 1、绝对路径
 * 2、base+相
 *
 * web 中 / 斜杠的不同意
 *
 * 在 web 中 / 斜杠 是一种绝对路径。
 * / 斜杠 如果被浏览器解析，得到的地址是：http://ip:port/
 *      <a href="/">斜杠</a>
 * / 斜杠 如果被服务器解析，得到的地址是：http://ip:port/工程路径
     * 1、<url-pattern>/servlet1</url-pattern>
     * 2、servletContext.getRealPath(“/”);
     * 3、request.getRequestDispatcher(“/”);
 * 特殊情况：
    * response.sendRediect(“/”); 把斜杠发送给浏览器解析。得到 http://ip:port
 *
 *
 * */

/**
 * @author lipeng
 * @version 1.0
 * @description: 请求的转发
 *请求转发是指，服务器收到请求后，从一次资源跳转到另一个资源的操作叫请求转发。
 *
 * @date 2022/8/7 22:12
 */

/**
 * 从Servlet1到Servlet2的操作叫做请求的转发
 * 特点：
 * 1：浏览器地址栏没有发生变化
 * 2：他们是一次请求
 * 3：他们共享Request 域中的数据
 * 4：可以转发到WEB-INF 目录下
 * 5：不可以访问工程以外的资源
 *
 * */

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        super.doGet(req, resp);
        //1：获取请求的参数

        String username = req.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）："+username);
        //2:给材料 盖一个章，并传递到Servlet2（柜台 2）去查看
        req.setAttribute("key1","柜台1 的章");

        //3:问路：Servlet2（柜台 2）怎么走
        /**
         * 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到IDEA代码的web目录<br/>
         *
         */

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form1.html");


        //4:走向Sevlet2（柜台 2）

        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
