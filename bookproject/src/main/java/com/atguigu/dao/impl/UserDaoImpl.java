package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 22:22
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT id,username,`password`,email FROM t_user WHERE username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User username) {
        String sql = "INSERT INTO t_user (`username`,`password`,`email`) VALUES (?,?,?)";
        return update(sql, username.getUsername(),username.getPassword(),username.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="SELECT id,username,`password`,email FROM t_user WHERE username=? AND password=?";
        return queryForOne(User.class, sql,username, password);
    }
}
