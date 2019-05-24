package com.neuedu.dao;

import com.neuedu.entity.Admin;
import com.neuedu.entity.Product;

import java.util.List;

public interface AdminDAO {
    List<Product> select();

    boolean findAll(Admin admin);
}
