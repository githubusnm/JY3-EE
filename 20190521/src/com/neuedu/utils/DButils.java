package com.neuedu.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DButils {
    private static Properties prop;
    static {
        prop = new Properties();
        try {
            prop.load(DButils.class.getResourceAsStream("/mysql.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String URL = prop.getProperty("url");
    private static final String USERNAME = prop.getProperty("username");
    private static final String PASSWORD = prop.getProperty("password");

    public static Connection getConnection(){
        Connection conn = null;
        if (null == conn){
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection(){
        Connection connection = null;
        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePrepareStatment(){
        PreparedStatement preparedStatement = null;
        if (null != preparedStatement){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(){
        ResultSet resultSet = null;
        if (null != resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
