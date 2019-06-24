package com.neuedu.service;

import com.neuedu.common.Const;
import com.neuedu.common.HigherResponse;
import com.neuedu.dao.CategoryMapper;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.User;
import com.sun.deploy.panel.JHighDPITable;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper cm;

    @Override
    public HigherResponse getCategory(Integer cId) {
        List<Category> categoryList = cm.querySubCategory(cId);
        if (null != categoryList){
            return HigherResponse.getResponseSuccess("查询成功。",categoryList);
        }
        return HigherResponse.getResponseFailed("查询失败。");
    }

    @Override
    public HigherResponse addOneCategory(Category c) {
        if (!StringUtils.isNotBlank(c.getName())){
            return HigherResponse.getResponseFailed("类别名不能为空");
        }
        int i = cm.queryCategoryName(c.getName());
        if (i>0){
            return HigherResponse.getResponseFailed("类别名已存在");
        }
        c.setStatus(1);
        int i1 = cm.insertSelective(c);
        if (i1 > 0){
            return HigherResponse.getResponseSuccess("添加类别成功");
        }
        return HigherResponse.getResponseSuccess("添加类别失败");
    }

    @Override
    public HigherResponse getCategory(HttpSession session, Integer cid) {
        return null;
    }

}
