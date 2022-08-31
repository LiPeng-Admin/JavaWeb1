package com.atguigu.servlet;

import com.atguigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: cookie
 * <p>
 * 1、Cookie 是服务器通知客户端保存键值对的一种技术。
 * 2、客户端有了 Cookie 后，每次请求都发送给服务器。
 * 3、每个 Cookie
 * @date 2022/8/29 23:34
 */
public class CookieServlet extends BaseServlet {
    /**
     * @param req
     * @param resp
     * @description: Cookie 创建
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/29 23:49
     */

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2：通知客户端 保存cookie
        resp.addCookie(cookie);

        //1：创建cookie对象2
        Cookie cookie1 = new Cookie("key2", "value2");
        //2：通知客户端 保存cookie
        resp.addCookie(cookie1);

        resp.getWriter().println("cookie 创建成功");


    }

    /**
     * @param req
     * @param resp
     * @description: cookie 获取
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/30 8:31
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName 返回cookie 名称（key）
            //getValue返回cookie的value值
            resp.getWriter().println("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");

        }
        Cookie iwantCookie = CookieUtils.findCookie("key2", cookies);
//        for (Cookie cookie : cookies) {
//            if("key2".equals(cookie.getName())){
//                iwantCookie=cookie;
//                break;
//            }
//        }
        //如果cookie 不等于null,说明赋过值，也就是找到了需要的cookie
        if (iwantCookie != null) {
            resp.getWriter().println("找到了需要的cookie");
        }

    }

    /**
     * @param req
     * @param resp
     * @description: 修改cookie
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/30 20:39
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //方案一：
        //1:先创建一个要修改的同名的cookie对象
        //2:在构造器上，同时赋予新的Cookie值
//        Cookie cookie = new Cookie("key1", "newValue1");
//        //3：调用response.addCookie(Cookie)
//        resp.addCookie(cookie);
//        resp.getWriter().println("key1的cookie值已经修改了"+cookie.getValue());

        //方案二：
        //1:先找到需要修改的Cookie对象
        Cookie cookie1 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie1 != null) {
            //2:调用setValue()方法赋予新的Cookie值
            cookie1.setValue("req.getCookies");
            //3:调用response.addCookie(cookie)通知客户端保存修改
            resp.addCookie(cookie1);
            resp.getWriter().println("key1的cookie值已经修改了" + cookie1.getValue());

        }


    }

    /**
     * @param req
     * @param resp
     * @description: cookie的生命控制
     * Cookie 的生命控制指的是如何管理 Cookie 什么时候被销毁（删除）
     * setMaxAge()
     * 正数，表示在指定的秒数后过期
     * 负数，表示浏览器一关，Cookie 就会被删除（默认值是-1）
     * 零，表示马上删除 Cookie
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/30 21:10
     */

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //负数，表示浏览器一关，Cookie 就会被删除（默认值是-1）
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);//设置cookie存活时间
        resp.addCookie(cookie);

    }

    protected void deletetNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：找到需要删除的cookie
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);//设置cookie存活时间,马上删除
            resp.addCookie(cookie);
        }
    }
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        正数，表示在指定的秒数后过期
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(60*60);//设置cookie存活时间:1小时后删除
            resp.addCookie(cookie);
        }
    }
    /**
     * @description:
     * Cookie 有效路径 Path 的设置
     * Cookie 的 path 属性可以有效的过滤哪些 Cookie 可以发送给服务器。哪些不发。
     * path 属性是通过请求的地址来进行有效的过滤。
     * CookieA path=/工程路径
     * CookieB path=/工程路径/abc
     * 请求地址如下：
     * http://ip:port/工程路径/a.html
     * CookieA 发送
     * CookieB 不发送
     * http://ip:port/工程路径/abc/a.html
     * CookieA 发送
     * CookieB 发送
     *
     * @param:
     * @param
     * @return:
     * @author lipeng
     * @date: 2022/8/30 21:54
     */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath:获取工程路径
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().println("创建了一个带有path路径的cookie");

    }

}
