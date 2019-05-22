package com.neuedu.impl;

import com.neuedu.dao.StudentDAO;
import com.neuedu.test.StudentManager;
import com.neuedu.utils.DataSourcePool;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    QueryRunner queryRunner = new QueryRunner();
    DataSourcePool dsp = DataSourcePool.getDsp();

    @Override
    public List<StudentManager> select() {
        Connection connection = dsp.getConnection();
        String sql = "select * from StudentManager";
        List<StudentManager> query = null;
        try {
            query = queryRunner.query(connection, sql, new BeanListHandler<>(StudentManager.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return query;
    }

    public void update(String student_name, String student_id) {
        Connection connection = dsp.getConnection();
        String sql = "update studentmanager set student_name = ? where student_id = ?";
        try {
            System.out.println(student_name);
            queryRunner.update(connection, sql,student_name,student_id);
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

    public void delete(String id){
        Connection connection = dsp.getConnection();
        String sql = "delete from studentmanager where student_id = ?";
        try {
            queryRunner.update(connection, sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
