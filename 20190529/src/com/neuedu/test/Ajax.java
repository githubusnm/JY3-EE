package com.neuedu.test;

import java.sql.*;

public class Ajax {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean findByName(String username) {
        boolean b = false;
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_", "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement("select username from user where username = ?");) {
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public boolean findAll(String name, String password) {
        ResultSet resultSet = null;
        boolean b = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_", "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement("select username ,userpassword from user where username = ? and userpassword = ?");) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return b;
    }
}
