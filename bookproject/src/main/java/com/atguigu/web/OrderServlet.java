package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: 生成订单
 * @date 2022/9/10 21:57
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        System.out.println("OrderServlet程序在线程【" + Thread.currentThread().getName() + "】中");
        Integer userId = loginUser.getId();
        //调用OrderService.createOrder(Cart,userId)
        String orderId = orderService.createOrder(cart, userId);

        //        req.setAttribute("orderId", orderId);
        //请求转发到 pages/cart/cartout.jsp
        req.getSession().setAttribute("orderId", orderId);

//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        //改用重定向方式避免表单重复提交
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
