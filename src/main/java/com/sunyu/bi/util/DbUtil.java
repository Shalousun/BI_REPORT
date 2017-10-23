package com.sunyu.bi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


/**
 * jdbc链接数据库的工具
 *
 * @author sunyu
 */
public class DbUtil {

    /**
     *
     */
    private static Logger logger = LoggerFactory.getLogger(DbUtil.class);

    /**
     * 获取数据
     *
     * @return
     */
    public static Connection getConnection(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("DBUtil无法连接指定的数据库:{}",e);
            logger.error("失败的连接为：{}",url);
            throw new ExceptionInInitializerError(e);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("DBUtil无法连接指定的数据库：{}",e);
            logger.error("失败的连接为：{}",url);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 获取数据库元数据
     *
     * @param connection
     * @return
     */
    public static DatabaseMetaData getDatabaseMetaData(Connection connection) {
        DatabaseMetaData databaseMetaData;
        try {
            databaseMetaData = connection.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return databaseMetaData;
    }

    /**
     * 关闭链接
     *
     * @param conn
     */
    public static void close(Connection conn) {
        DbUtil.close(conn, null, null);
    }

    /**
     * 关闭链接
     *
     * @param conn
     * @param rs
     */
    public static void close(Connection conn, ResultSet rs) {
        DbUtil.close(conn, null, rs);
    }

    /**
     * 关闭链接
     *
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void close(Connection conn, Statement pstmt, ResultSet rs) {
        try {
            if (null != rs) {
                rs.close();
            }
            if (null != pstmt) {
                pstmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("DBUtil关闭数据库链接异常：{}", e.getMessage());
            e.printStackTrace();
        }
    }
}

