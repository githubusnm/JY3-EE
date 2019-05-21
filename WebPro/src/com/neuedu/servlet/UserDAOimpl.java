package com.neuedu.servlet;

import com.neuedu.user.User;
import com.neuedu.utils.DButils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.pkcs11.Secmod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class UserDAOimpl extends UserDAO {

    public String jiami(String string) {
        final BASE64Encoder encoder = new BASE64Encoder();
        String encode = null;
        try {
            byte[] bytes = string.getBytes("UTF-8");
            encode = encoder.encode(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

    public String jiemi(String string) {
        String s = null;
        final BASE64Decoder decoder = new BASE64Decoder();
        try {
            s = new String(decoder.decodeBuffer(string), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void insert(User user) {

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into user (username,password) values(?,?)");) {
            String jiamiusername = jiami(user.getUsername());
            String jiamipassword = jiami(user.getPassword());
            preparedStatement.setString(1, jiamiusername);
            preparedStatement.setString(2, jiamipassword);
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findByUsername(String username) {

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select username from user where username = ?")) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                if (name != username) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.closeResultSet();
        }
        return false;
    }

    public boolean findAll(User user) {
        ResultSet resultSet = null;
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select username,password from user where username = ? and password = ?");) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String loginname = resultSet.getString(1);
//                String loginpassword = resultSet.getString(2);
//                if (user.getUsername().equals(loginname) && user.getPassword().equals(loginpassword)){
//                    return true;
//                }
//            }
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.closeResultSet();
        }
        return false;
    }

    public void delete(int id) {
        try {
            Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String password, String username) {

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update user set password = ? where username = ?");
        ) {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

