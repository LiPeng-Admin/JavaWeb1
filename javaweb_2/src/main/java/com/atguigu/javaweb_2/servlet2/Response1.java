package com.atguigu.javaweb_2.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description:
 * @date 2022/8/8 20:54
 */

/**
 * 请求重定向的特点
 *
 *  * 1：浏览器地址栏发生发生变化
 *  * 2：他们是两次请求
 *  * 3：他们不共享Request 域中的数据
 *  * 4：不可以转发到WEB-INF 目录下
 *  * 5：可以访问工程以外的资源，如百度
 *
 *
 * */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游");

        //重定向方式1：
        //1：设置响应状态码302
//        resp.setStatus(302);
        //2：设置响应头,说明新的地址在哪里
////        resp.setHeader("Location", "http://localhost:8080/javaweb_2/response2");
//
//        resp.setHeader("Location", "https://www.bilibili.com/");

        //重定向方式2：（推荐）
        resp.sendRedirect("https://www.bilibili.com/");



        req.setAttribute("key", "value");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
