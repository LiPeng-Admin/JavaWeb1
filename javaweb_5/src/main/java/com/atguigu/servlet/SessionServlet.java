package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: Session
 * <p>
 * 1、Session 就一个接口（HttpSession）。
 * 2、Session 就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。
 * 3、每个客户端都有自己的一个 Session 会话。
 * 4、Session 会话中，我们经常用来保存用户登录之后的信息
 * @date 2022/8/30 23:46
 */
public class SessionServlet extends BaseServlet {
    /**
     * @param req
     * @param resp
     * @description: session 创建
     * 如何创建 Session 和获取(id 号,是否为新)
     * 如何创建和获取 Session。它们的 API 是一样的。
     * request.getSession()
     * 第一次调用是：创建 Session 会话
     * 之后调用都是：获取前面创建好的 Session 会话对象。
     * isNew(); 判断到底是不是刚创建出来的（新的）
     * true 表示刚创建
     * false 表示获取之前创建
     * 每个会话都有一个身份证号。也就是 ID 值。而且这个 ID 是唯一的。
     * getId() 得到 Session 的会话 id 值。
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/30 23:50
     */

    protected void createSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session 会话对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建出来的
        boolean isNew = session.isNew();
        //获取session会话的唯一标识
        String id = session.getId();

        resp.getWriter().println("得到的session,它的id是" + id + "<br/>");
        resp.getWriter().println("这个session是否是新创建到的" + isNew);

    }

    /**
     * @param req
     * @param resp
     * @description: 向session 中保存数据
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/31 23:33
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");


    }

    /**
     * @param req
     * @param resp
     * @description: Session域数据的获取
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/31 23:42
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().println("从session中获取key1的数据：" + attribute);

    }

    /**
     * @param req
     * @param resp
     * @description: session 默认超时时长
     * public void setMaxInactiveInterval(int interval) 设置 Session 的超时时间（以秒为单位），超过指定的时长，Session
     * 就会被销毁。
     * 值为正数的时候，设定 Session 的超时时长。
     * 负数表示永不超时（极少使用）
     * public int getMaxInactiveInterval()获取 Session 的超时时间
     * public void invalidate() 让当前 Session 会话马上超时无效。
     * Session 默认的超时时长是多少！
     * Session 默认的超时时间长为 30 分钟。
     * <p>
     * <p>
     * 你希望你的 web 工程，默认的 Session 的超时时长为其他时长。你可以在你自己的 web.xml 配置文件中做
     * 以上相同的配置。就可以修改你的 web 工程所有 Seession 的默认超时时长。
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/1 21:23
     */

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session 的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().println("session的默认超时时长是：" + maxInactiveInterval);

    }

    /**
     * @param null
     * @description: 设置session超时时长为xxx秒
     * 正数表示超时时长，负数表示永不超时
     * 0表示马上超时
     * @param:
     * @return:
     * @author lipeng
     * @date: 2022/9/1 21:34
     */

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session 对象
        HttpSession session = req.getSession();
        //设置当前session 3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().println("设置session超时时长为3秒后超时");
    }

    /**
     * @param
     * @description: 设置马上超时，即session.setMaxInactiveInterval(0);
     * @param:
     * @return:
     * @author lipeng
     * @date: 2022/9/1 21:59
     */

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().println("session马上超时销毁");

    }


}
