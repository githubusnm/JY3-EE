package com.neuedu.service;

import com.neuedu.common.HigherResponse;
import com.neuedu.pojo.Category;

import javax.servlet.http.HttpSession;

public interface CategoryService {

    HigherResponse getCategory(HttpSession session,Integer cid);

    HigherResponse getCategory(Integer cId);

    HigherResponse addOneCategory(Category c);

}
