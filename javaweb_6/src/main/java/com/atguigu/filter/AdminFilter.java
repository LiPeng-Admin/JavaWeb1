package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 0:05
 */
/**
 * @description:
 * filter拦截器的使用步骤
 *
 * 1、编写一个类去实现 Filter 接口
 * 2、实现过滤方法 doFilter()
 * 3、到 web.xml 中去配置 Filter 的拦截路径
 *
 * @param:
 * @param
 * @return:
 * @author lipeng
 * @date: 2022/9/11 11:35
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1.Filter构造器方法AdminFilter");
    }

    /**
     * @param
     * @param
     * @param
     * @description: doFilter()方法专门用来拦截请求，可以完成权限检查
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/11 0:06
     */


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的初始化方法");
        //1、获取 Filter 的名称 filter-name 的内容
        System.out.println(filterConfig.getFilterName());
        //2、获取在 web.xml 中配置的 init-param 初始化参数
        System.out.println(filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getInitParameter("url"));
        //3、获取 ServletContext 对象
        System.out.println(filterConfig.getServletContext());

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain  filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
// 如果等于 null，说明还没有登录
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
// 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }



    @Override
    public void destroy() {
        System.out.println("4.Filter 的销毁方法");
    }
}
