package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
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
 * @description: TODO
 * @date 2022/8/28 20:58
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * @param req
     * @param resp
     * @description:处理前台分页功能
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/28 10:08
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1:获取请求的参数：pageSize ,pageNo
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2:调用bookservice.page(pageSize, pageNo) :page 对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");
        //3:保存page 对象到request域中
        req.setAttribute("page", page);
        //4:请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    /**
     * @param req
     * @param resp
     * @description: 处理价格区间的分页功能
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/8/29 8:21
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1:获取请求的参数：pageSize ,pageNo
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2:调用bookservice.page(pageSize, pageNo) :page 对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数，则追加到请求参数中
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格的参数，则追加到请求参数中
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3:保存page 对象到request域中
        req.setAttribute("page", page);
        //4:请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }
}
