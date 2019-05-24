package com.neuedu.impl;

import com.neuedu.dao.UserDAO;
import com.neuedu.entity.User;
import com.neuedu.utils.DruidPool;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    DruidPool pool = DruidPool.getPool();
    QueryRunner queryRunner = new QueryRunner();

    public boolean findAll(User user) {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select username,userpassword from user where username = ? and userpassword = ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserpassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void insert(User user) {
        Connection connection = pool.getConnection();
        String sql = "insert into user values(?,?,?,now())";
        try {
            queryRunner.update(connection, sql, user.getUserid(), user.getUsername(), user.getUserpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean findUsername(String string){
        Connection connection = pool.getConnection();
        String sql = "select username from user where username = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, string);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
