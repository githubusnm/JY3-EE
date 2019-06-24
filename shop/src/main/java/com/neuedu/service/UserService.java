package com.neuedu.service;

import com.neuedu.common.HigherResponse;
import com.neuedu.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    User selectUserById(Integer id);

    //根据用户名和密码查询用户信息
    HigherResponse login(String username, String psw,HttpSession session);

    //注册
    HigherResponse register(User user);

    //获取密保问题
    HigherResponse forgetPsw_Qes(String userName);

    //提交问题答案
    HigherResponse forgetCheckAnswer(String username,String question,String answer);

    //忘记密码中的重置密码
    HigherResponse forgetresetpassword(String username,String newpsw,String token);

    //登录状态的重置密码
    HigherResponse ResetPassword(HttpSession session,String oldpsw,String newpsw);

    //登录状态下修改个人信息
    HigherResponse Update_Information(HttpSession session,User user);
}
