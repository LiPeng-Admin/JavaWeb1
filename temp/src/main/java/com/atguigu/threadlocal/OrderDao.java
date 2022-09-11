package com.atguigu.threadlocal;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 20:08
 */
public class OrderDao {
    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao 当前线程【"+name+"】中保存的数据是："+ThreadLocalTest.threadLocal.get());

    }
}
