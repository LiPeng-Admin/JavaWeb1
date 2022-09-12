package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/12 15:53
 */
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");
        Person person = new Person(1, "张三");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }


    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax请求进来了");
        Person person = new Person(1, "lisi");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGet请求进来了");
        Person person = new Person(1, "wangwu");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPost请求进来了");
        Person person = new Person(1, "bajie");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }
    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGetJson请求进来了");
        Person person = new Person(1, "wzg168");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize请求进来了");
        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));
        Person person = new Person(1, "test");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().println(personJsonString);

    }



}
