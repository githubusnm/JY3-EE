package com.neuedu.servlet;

import com.neuedu.user.User;

public abstract class UserDAO {

    abstract void insert(User user);

    abstract boolean findByUsername(String username);

    abstract void delete(int id);

}
