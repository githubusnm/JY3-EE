package com.neuedu.controller.back;

import com.neuedu.common.HigherResponse;
import com.neuedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager/user")
public class AdminCon {

    @Autowired
    private AdminService as;

    /**
     * 管理员登录
     */
    @ResponseBody
    @RequestMapping("/login.do")
    public HigherResponse adminLogin(String username, String psw, HttpSession session){
        return as.login(username, psw, session);
    }
}
