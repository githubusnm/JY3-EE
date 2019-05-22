package com.neuedu.dao;

import com.neuedu.test.StudentManager;

import java.util.List;

public interface StudentDAO {
    List<StudentManager> select();

    void update(String student_name, String student_id);

    void delete(String id);
}
