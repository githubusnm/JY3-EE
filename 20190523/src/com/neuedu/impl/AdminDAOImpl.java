package com.neuedu.impl;

import com.neuedu.entity.Admin;
import com.neuedu.entity.Product;
import com.neuedu.dao.AdminDAO;
import com.neuedu.utils.DruidPool;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    QueryRunner queryRunner = new QueryRunner();
    DruidPool pool = DruidPool.getPool();

    @Override
    public List<Product> select() {
        return null;
    }

    @Override
    public boolean findAll(Admin admin) {
        Connection connection = pool.getConnection();
        String sql = "select adminname,adminpassword from admin where adminname = ? and adminpassword = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getAdminname());
            preparedStatement.setString(2, admin.getAdminpassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
