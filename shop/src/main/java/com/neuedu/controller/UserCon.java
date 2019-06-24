package com.neuedu.controller;

import com.neuedu.common.HigherResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserCon {

    @Autowired
    private UserService us;

    @ResponseBody
    @RequestMapping("/login.do")
    public HigherResponse login(String username , String psw, HttpSession session){
        return us.login(username, psw,session);
    }

    @ResponseBody
    @RequestMapping("/register.do")
    public HigherResponse register(User user){
        return us.register(user);
    }

    //查询密保问题
    @ResponseBody
    @RequestMapping("/forget_get_question.do")
    public HigherResponse queryQues(String userName){
        return us.forgetPsw_Qes(userName);
    }

    /**
     * 提交问题答案
     */
    @ResponseBody
    @RequestMapping("/forget_get_question.do")
    public HigherResponse forget_check_answer(String username,String question,String answer){
        return us.forgetCheckAnswer(username, question, answer);
    }

    /**
     * 忘记密码中的重设密码
     */
    @ResponseBody
    @RequestMapping("/forget_get_question.do")
    public HigherResponse forget_reset_password(String username,String newpsw,String token){
        return null;
    }

    /**
     * 登录状态的重置密码
     */
    @ResponseBody
    @RequestMapping("/forget_get_question.do")
    public HigherResponse reset_password(String username,String pswOld,String pswNew){
        return us.forgetCheckAnswer(username, pswOld, pswOld);
    }

    @ResponseBody
    @RequestMapping("/reset_password.do")
    public HigherResponse reset_password(HttpSession session,String pswOld,String newpsw){
        return us.ResetPassword(session, pswOld, newpsw);
    }

    /**
     * 登录状态更新个人信息
     */
    @ResponseBody
    @RequestMapping("/update_information.do")
    public HigherResponse update_information(HttpSession session,User user){
        return us.Update_Information(session, user);
    }

    /**
     *
     */

}
