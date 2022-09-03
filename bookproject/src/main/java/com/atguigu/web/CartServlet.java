package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: 购物车操作
 * @date 2022/9/3 17:36
 */
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * @param req
     * @param resp
     * @description: 加入购物车
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/3 17:37
     */

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById获取图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(cartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);
//        System.out.println(cart);
//        System.out.println("请求头Referer的值：" + req.getHeader("Referer"));
        //重定向回原来商品所在的页面
//        resp.sendRedirect(req.getContextPath());
        resp.sendRedirect(req.getHeader("Referer"));


    }

    /**
     * @param req
     * @param resp
     * @description: 删除购物车商品
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/3 22:25
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断购物车列表是否有商品
        if (cart != null) {
            cart.deleteItem(id);
            //重定向回原来商品所在的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * @param req
     * @param resp
     * @description: 清空购物车
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/3 23:28
     */

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //购物车不为空
        if (cart != null) {
            cart.clear();
            //重定向回原来商品所在的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }


    }
}
