package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"admintest2","123456","admintest2@126.com"));
        userService.registerUser(new User(null,"admintest3","123456","admintest3@126.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admintest2", "123456", "admintest2@126.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admintest4")){
            System.out.println("用户名已存在");

        }else{
            System.out.println("用户名不存在");
        }

    }
}