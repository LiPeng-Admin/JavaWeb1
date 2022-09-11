package com.atguigu.threadlocal;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 19:59
 */
public class OrderService {

    public void createOder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程【"+name+"】中保存的数据是："+ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();

    }
}
