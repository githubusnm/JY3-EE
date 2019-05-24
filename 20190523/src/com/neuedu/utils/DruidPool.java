package com.neuedu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidPool {
    private static Properties prop;
    private static DruidPool dp;
    private static DataSource dds;

    private DruidPool() {
    }

    public static DruidPool getPool() {
        if (null == dp) {
            dp = new DruidPool();
        }
        return dp;
    }

    static{
        try {
            prop = new Properties();
            prop.load(DruidPool.class.getResourceAsStream("/DataSource.properties"));
            dds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String URL = prop.getProperty("url");
    private static String USERNAME = prop.getProperty("username");
    private static String PASSWORD = prop.getProperty("password");

    public Connection getConnection(){
        try {
            return dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
