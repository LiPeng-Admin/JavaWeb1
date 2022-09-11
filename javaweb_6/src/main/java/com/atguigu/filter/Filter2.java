package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 15:59
 */
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2前置代码1");
        chain.doFilter(request, response);
        System.out.println("Filter2后置代码2");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
