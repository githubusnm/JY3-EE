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
        String sql = "select * from Student";
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

    public void update(StudentManager studentManager) {
        Connection connection = dsp.getConnection();
        String sql = "update student set student_name = ?,student_password = ? where id = ?";
        try {
            queryRunner.update(connection, sql,studentManager.getStudent_name(),studentManager.getStudent_password(),studentManager.getId());
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
        String sql = "delete from student where id = ?";
        try {
            queryRunner.update(connection, sql,id);
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
