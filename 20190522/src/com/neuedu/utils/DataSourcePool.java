package com.neuedu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourcePool {
    private static DataSource ds;
    private static DataSourcePool dsp;
    private static Properties prop;

    private DataSourcePool() {
    }

    static {
        try {
            prop = new Properties();
            prop.load(DataSourcePool.class.getResourceAsStream("/DataSource.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSourcePool getDsp(){
        if (null == dsp){
            dsp = new DataSourcePool();
        }
        return dsp;
    }

    public Connection getConnection() {
            try {
                return ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

}
