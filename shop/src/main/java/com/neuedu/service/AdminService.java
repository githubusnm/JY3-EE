package com.neuedu.service;

import com.neuedu.common.HigherResponse;

import javax.servlet.http.HttpSession;

public interface AdminService {

    //登录
    HigherResponse login(String username, String psw, HttpSession session);

}
