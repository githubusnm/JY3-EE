package com.neuedu.servlet;

import com.neuedu.user.User;

import java.util.List;

public abstract class UserDAO {

    abstract void insert(User user);

    abstract boolean findByUsername(String username);

    abstract void delete(int id);

    abstract List<User> select();

    abstract void update(String password, String username);

    abstract boolean findAll(User user);

}
