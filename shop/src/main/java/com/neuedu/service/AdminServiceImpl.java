package com.neuedu.service;

import com.neuedu.common.Const;
import com.neuedu.common.HigherResponse;
import com.neuedu.dao.UserMapper;
import com.neuedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper um;

    @Override
    public HigherResponse login(String username, String psw, HttpSession session) {
        if (psw == null || psw.length() == 0) {
            return HigherResponse.getResponseFailed("密码不能为空。");
        }
        if (username == null || username.length() == 0) {
            return HigherResponse.getResponseFailed("用户名不能为空。");
        }
        int a = um.selectUserByUsername(username);
        if (a == 0) {
            return HigherResponse.getResponseFailed("用户名不存在。");
        }
        User user = um.selectUserByUserNameAndPsw(username, psw);
        if (null != user) {
            if (user.getRole().intValue() == Const.COMMONADMIN) {
                session.setAttribute(Const.CURRENTADMIN, user);
                return HigherResponse.getResponseSuccess("登陆成功。",user);
            }
        }
        return HigherResponse.getResponseFailed("用户名或密码有误。");
    }
}
