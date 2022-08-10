package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
    *根据用户名查询用户信息
    * @return 如果返回null.表示没有这个用户
    * */
    public User queryUserByUsername(String username);

    /**
     *保存用户信息
     *
     * */

    public int saveUser(User username);


    /**
     *根据用户名和密码查询用户
     * 如果返回null,说明用户名或密码不对
     *
     * */
    public  User queryUserByUsernameAndPassword(String username, String password);



}
