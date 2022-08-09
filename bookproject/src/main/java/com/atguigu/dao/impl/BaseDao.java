package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lipeng
 * @version 1.0
 * @description: 封装了针对于数据表的通用操作
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装
 * @date 2022/8/9 0:19
 */
public abstract class BaseDao {

   private   QueryRunner queryRunner = new QueryRunner();

    /*
     *update
     * */

    public int update(String sql, Object... args) {
        try {
            Connection connection = JDBCUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }
}
