package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author AOA
 * @version 1.0
 * @description: 数据库连接池
 * @date 2022/4/18 21:51
 */

public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
//            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("jdbc.properties");
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return connection;
    }

    public static void commitAndClose(){
        Connection conn = threadLocal.get();
        if (conn != null){
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DbUtils.closeQuietly(conn);
            }
        }
        threadLocal.remove();
    }

    public static void rollbackAndClose(){
        Connection conn = threadLocal.get();
        if (conn != null){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DbUtils.closeQuietly(conn);
            }
        }
        threadLocal.remove();
    }

//    public static void close(Connection connection){
//        DbUtils.closeQuietly(connection);
//    }

}
