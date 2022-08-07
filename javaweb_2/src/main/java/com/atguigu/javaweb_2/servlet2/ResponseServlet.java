package com.atguigu.javaweb_2.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lipeng
 * @version 1.0
 * @description: HttpServletResponse 类的作用
 * <p>
 * HttpServletResponse 类和 HttpServletRequest 类一样。每次请求进来，Tomcat 服务器都会创建一个 Response 对象传
 * 递给 Servlet 程序去使用。HttpServletRequest 表示请求过来的信息，HttpServletResponse 表示所有响应的信息，
 * 我们如果需要设置返回给客户端的信息，都可以通过 HttpServletResponse 对象来进行设置
 * <p>
 * 两个输出流的说明
 * <p>
 * 字节流 getOutputStream(); 常用于下载（传递二进制数据）
 * 字符流 getWriter(); 常用于回传字符串（常用）
 * @date 2022/8/7 23:29
 */
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getCharacterEncoding());//默认是ISO-8859-1
//方式一：
//        //设置服务器字符集UTF-8
//        resp.setCharacterEncoding("UTF-8");
//
//        //通过响应头，设置浏览器也使用字符集UTF-8
//        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        //方式二：同时设置服务器和浏览器字符集UTF-8，还设置了响应头
        //此方法需要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");


        PrintWriter writer = resp.getWriter();
        writer.println("response返回给客户端");

    }
}
