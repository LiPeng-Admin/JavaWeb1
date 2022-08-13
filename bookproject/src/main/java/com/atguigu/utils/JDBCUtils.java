package com.atguigu.utils;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/8 23:07
 */
public class JDBCUtils {

    /*
     * 获取数据库连接池的连接
     *
     * */
    private static DataSource source1;
    static {
        try {
            Properties properties = new Properties();
/**
 * 注意事项：此处使用类加载器，不能使用系统加载器，否则后面项目会出现空指针异常
 * */
            InputStream stream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            properties.load(stream);
            source1 = BasicDataSourceFactory.createDataSource(properties);
            System.out.println(source1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }


    public static Connection getConnection() throws SQLException {
        Connection connection = source1.getConnection();
        return connection;
    }

    /*
     *
     *关闭连接*/
    public static void closeResoure(Connection connection) {
        try {
            if(connection !=null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
