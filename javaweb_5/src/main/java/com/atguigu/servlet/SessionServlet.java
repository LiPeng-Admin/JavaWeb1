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
 *
 * 1、Session 就一个接口（HttpSession）。
 * 2、Session 就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。
 * 3、每个客户端都有自己的一个 Session 会话。
 * 4、Session 会话中，我们经常用来保存用户登录之后的信息
 *
 * @date 2022/8/30 23:46
 */
public class SessionServlet extends BaseServlet {
    /**
     * @description: session 创建
     *  如何创建 Session 和获取(id 号,是否为新)
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
     * @param req
     * @param resp
     * @return: void
     * @author lipeng
     * @date: 2022/8/30 23:50
     */

    protected void createSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session 会话对象
        HttpSession session = req.getSession();

    }
}
