package com.neuedu.dao;

import com.neuedu.test.StudentManager;

import java.util.List;

public interface StudentDAO {
    List<StudentManager> select();

    void update(StudentManager studentManager);

    void delete(String id);
}
