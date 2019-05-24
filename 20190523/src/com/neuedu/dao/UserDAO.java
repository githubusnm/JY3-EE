package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDAO {
    boolean findAll(User user);

    void insert(User user);

    boolean findUsername(String string);
}
