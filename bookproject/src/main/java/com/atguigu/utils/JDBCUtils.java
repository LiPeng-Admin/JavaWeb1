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
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

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
        Connection conn = conns.get();
        if (conn == null) {

            conn = source1.getConnection();//从数据库连接池获取连接
            conns.set(conn);//保存到ThreadLocal 对象中
            conn.setAutoCommit(false);//设置为手动管理事务
        }
        return conn;

    }

    /**
     * @description: 提交事务并关闭释放连接
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/11 20:59
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.commit();//提交事务

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();//关闭连接，释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //需要使用remove操作，否则会报错（tomcat底层使用了线程池技术）

        conns.remove();
    }

    /**
     * @param
     * @description: 回滚事务并关闭释放连接
     * @param:
     * @return:
     * @author lipeng
     * @date: 2022/9/11 20:59
     */

    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();//回滚事务

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();//关闭连接，释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //需要使用remove操作，否则会报错（tomcat底层使用了线程池技术）

        conns.remove();

    }
    /*
     *
     *关闭连接*/
//    public static void closeResoure(Connection connection) {
//        try {
//            if (connection != null)
//                connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
