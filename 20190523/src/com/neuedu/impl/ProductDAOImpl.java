package com.neuedu.impl;

import com.neuedu.dao.ProductDAO;
import com.neuedu.entity.Product;
import com.neuedu.utils.DruidPool;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO {
    DruidPool pool = DruidPool.getPool();
    QueryRunner queryRunner = new QueryRunner();

    @Override
    public void insert(Product product) {
        Connection connection = pool.getConnection();
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(connection, sql, product.getPro_id(),
                    product.getPro_name(), product.getPro_price(), product.getPro_image(),
                    product.getPro_des(), product.getPro_stock(), product.getPro_date(),
                    product.getPro_category_id(), product.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
