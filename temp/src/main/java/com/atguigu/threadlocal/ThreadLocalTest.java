package com.atguigu.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/11 19:38
 */
public class ThreadLocalTest {
//    public static Map<String, Object> data = new Hashtable<>();
    private static Random random = new Random();
    public static ThreadLocal<Object>threadLocal = new ThreadLocal<Object>();

    public static class Task implements Runnable {
        @Override
        public void run() {
            //在Run()方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);//获取0-999随机数

            String name = Thread.currentThread().getName(); //获取当前线程名
            System.out.println("线程为【" + name + "】的随机数是:" + i);
//            data.put(name, i);
            threadLocal.set(i);
            try {

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOder();
            //在Run()方法结束之前，以当前线程名获取数据并打印，查看是否可以取出操作
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程是【"+name+"】快结束时取出的关联数据是:"+o);


        }
    }

    public static void main(String[] args) {
        //创建三个线程
        for (int i = 0; i <3 ; i++) {
            new Thread(new Task()).start();

        }

    }
}
