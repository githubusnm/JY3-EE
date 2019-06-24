package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class getUserInfo {

    @Autowired
    private UserService us;

    @RequestMapping("/getUser.do")
    public String getUserInfo(Integer id){
        User user = us.selectUserById(id);
        System.out.println(user);
        return "User";
    }


}
