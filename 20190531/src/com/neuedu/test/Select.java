package com.neuedu.test;

import java.sql.*;

public class Select {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean findAll(String username,String password){
        boolean b = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select username,userpassword from user where username = ? and userpassword = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
}
