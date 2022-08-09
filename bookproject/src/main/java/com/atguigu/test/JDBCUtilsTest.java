package com.atguigu.test;

import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/8 23:53
 */
public class JDBCUtilsTest {
    @Test
    public void testJdbcUtils () throws SQLException {
        for (int i = 0; i <100; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
           JDBCUtils.closeResoure(connection);

        }


    }
}
