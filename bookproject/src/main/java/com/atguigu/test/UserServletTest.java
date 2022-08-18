package com.atguigu.test;
import java.lang.reflect.Method;


/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/17 22:59
 */
public class UserServletTest {

    public void login(){
        System.out.println("这是login()方法调用了");
    }

    public void regist(){
        System.out.println("这是regist()方法调用了");
    }

    public void updateUser(){
        System.out.println("这是UpDateUser()方法调用了");
    }

    public void updateUserPassword(){
        System.out.println("这是UpdateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action="updateUser";
        try {
            //通过action 业务   鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            //调用目标业务方法
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
