package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 21:56
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("action");

        try {
            //通过action 业务 鉴别字符串，获取相应的业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(parameter, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法

            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
