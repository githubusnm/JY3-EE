package com.neuedu.controller.back;

import com.google.common.cache.CacheBuilder;
import com.neuedu.common.Const;
import com.neuedu.common.HigherResponse;
import com.neuedu.dao.CategoryMapper;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.User;
import com.neuedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/manager/category")
@RestController
public class CateCon {

    @Autowired
    private CategoryService cs;

    @RequestMapping("get_category.do")
    public HigherResponse getCategory(HttpSession session, @RequestParam(defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENTADMIN);
        if (null == user){
            return HigherResponse.getResponseFailed("请登录。");
        }if (user.getRole().intValue() !=Const.COMMONADMIN){
            return HigherResponse.getResponseFailed("无访问权限。");
        }
        HigherResponse category = cs.getCategory(categoryId);
        return category;
    }

    @RequestMapping("/add_category.do")
    public HigherResponse get_category(HttpSession session,@RequestParam(defaultValue = "0") Integer parentId,String cateName){
        User user = (User) session.getAttribute(Const.CURRENTADMIN);
        if (null == user){
            return HigherResponse.getResponseFailed("请登录。");
        }if (user.getRole().intValue() !=Const.COMMONADMIN){
            return HigherResponse.getResponseFailed("无访问权限。");
        }
        Category category = new Category();
        category.setName(cateName);
        category.setParentId(parentId);
        return cs.addOneCategory(category);
    }



}
