package com.neuedu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Test {

    private static Test ts;
    private static Properties prop;
    private static DataSource ds;

    static{
        prop = new Properties();
        try {
            prop.load(Test.class.getResourceAsStream("/DataSource.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test(){}

    public static Test getPool(){
        if (null == ts){
            ts = new Test();
        }
        return ts;
    }

    public Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_", "root", "123456");
//            QueryRunner queryRunner = new QueryRunner();
//            String sql = "select * from studentmanager";
//            queryRunner.update(connection, sql,9,"无用");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_", "root", "123456");
//            QueryRunner queryRunner = new QueryRunner();
//            String sql = "update studentmanager set student_name = ? where student_id = ? ";
//            queryRunner.update(connection, sql,"吴用",9);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_", "root", "123456");
//            QueryRunner queryRunner = new QueryRunner();
//            String sql = "select * from studentmanager";
//            List<StudentManager> query = queryRunner.query(connection, sql, new BeanListHandler<>(StudentManager.class));
//            System.out.println(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            Test pool = Test.getPool();
            Connection connection = pool.getConnection();
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_", "root", "123456");
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from studentmanager where student_id = ?";
            StudentManager query = queryRunner.query(connection, sql, new BeanHandler<>(StudentManager.class),9);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
