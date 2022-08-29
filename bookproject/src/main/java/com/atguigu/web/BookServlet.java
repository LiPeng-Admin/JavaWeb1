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
import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 16:18
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //1:获取请求的参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2:调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3:跳转到图书列表页
        //注意此处不能使用请求转发的方式，会造成表单重复提交，应该使用重定向
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:获取请求的参数id,图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 10);

        //2:调用BookService.deleteBookById:删除图书
        bookService.deleteBookById(id);
        //3:重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:获取请求的参数对象=封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2:调用BookService.updateBook()修改图书
        bookService.updateBook(book);
        //3:重定向回到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:获取请求的参数图书标号
        int id = WebUtils.parseInt(req.getParameter("id"), 10);
        //2:调用BookService.queryBookById 查询图书
        Book book = bookService.queryBookById(id);
        //3:保存图书到Request域中
        req.setAttribute("book", book);
        //4:请求转发到 pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1:通过Bookservice查询全部图书
        List<Book> books = bookService.queryBooks();
        System.out.println(books);
        //2:把全部图书保存在request域中
        req.setAttribute("books", books);
        //3:请求转发到/pages/manager/manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


 /**
  * @description:处理分页功能
  * @param:
  * @param req
  * @param resp
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

        page.setUrl("manager/bookServlet?action=page");
        //3:保存page 对象到request域中
        req.setAttribute("page", page);
        //4:请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }
}
