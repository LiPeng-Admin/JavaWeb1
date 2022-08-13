package com.atguigu.listener;

import javax.servlet.ServletContextEvent;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 22:58
 */
public class ServletContextListenerImpl implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建了");    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");
    }
}
