package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * */
    public void registerUser(User user);
    /**
     * 用户登录
     * */
    public User login(User user);

    /**
     * 检查用户是否可用
     *返回true,表示用户名已存在，表示用户名已存在，返回false,表示用户名可用
     * */

    public boolean existsUsername(String username);
}
