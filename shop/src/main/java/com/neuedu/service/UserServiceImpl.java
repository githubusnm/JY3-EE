package com.neuedu.service;

import com.github.pagehelper.StringUtil;
import com.neuedu.common.Const;
import com.neuedu.common.GuavaCache;
import com.neuedu.common.HigherResponse;
import com.neuedu.common.StatusUtil;
import com.neuedu.dao.UserMapper;
import com.neuedu.pojo.User;
import com.neuedu.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public User selectUserById(Integer id) {
        return um.selectByPrimaryKey(id);
    }

    @Override
    public HigherResponse login(String username, String psw, HttpSession session) {
        if (username == null || username.length() == 0) {
            return HigherResponse.getResponseFailed("用户名不能为空。");
        }
        if (psw == null || psw.length() == 0) {
            return HigherResponse.getResponseFailed("密码不能为空。");
        }
        int i = um.selectUserByUsername(username);
        if (i == 0) {
            return HigherResponse.getResponseFailed("用户名不存在");
        }
        User user = um.selectUserByUserNameAndPsw(username, psw);
        if (user == null) {
            return HigherResponse.getResponseFailed("用户名或密码错误。");
        }
        session.setAttribute(Const.CURRENTUSER, user);
        return HigherResponse.getResponseSuccess("登陆成功，", user);
    }


    @Override
    public HigherResponse register(User user) {
        if (!StringUtils.isNotBlank(user.getUsername())) {
            return HigherResponse.getResponseFailed("用户名错误。");
        }
        if (!StringUtils.isNotBlank(user.getPassword())) {
            return HigherResponse.getResponseFailed("密码错误。");
        }
        if (!StringUtils.isNotBlank(user.getEmail())) {
            return HigherResponse.getResponseFailed("邮箱错误。");
        }
        if (!StringUtils.isNotBlank(user.getPhone())) {
            return HigherResponse.getResponseFailed("联系方式错误。");
        }
        if (!StringUtils.isNotBlank(user.getQuestion())) {
            return HigherResponse.getResponseFailed("密保问题错误。");
        }
        if (!StringUtils.isNotBlank(user.getAnswer())) {
            return HigherResponse.getResponseFailed("密保答案错误。");
        }

        //判断用户名是否存在
        //判断邮箱是否存在
        HigherResponse higherResponse = checkValId(user.getUsername(), Const.USERNAME);
        if (higherResponse.getStatus() == StatusUtil.FAILED_STATUS) {
            return HigherResponse.getResponseFailed("邮箱已存在。");
        }
        //加密密码
        String s = MD5Util.MD5Encode(user.getPassword(), null);
        //设置用户角色
        user.setRole(Const.COMMONUSER);
        //调用添加的方法
        int insert = um.insert(user);
        if (insert == 0) {
            return HigherResponse.getResponseFailed("注册失败。");
        }
        return higherResponse.getResponseSuccess("注册成功。");
    }

    @Override
    public HigherResponse forgetPsw_Qes(String userName) {
        if (!StringUtils.isNotBlank(userName)) {
            return HigherResponse.getResponseFailed("输入用户名为空。");
        }
        HigherResponse higherResponse = this.checkValId(userName, Const.USERNAME);
        if (higherResponse.isResponseSuccess()) {
            return HigherResponse.getResponseFailed("用户不存在");
        }
        String quesByUserName = um.getQuesByUserName(userName);
        return HigherResponse.getResponseSuccess(quesByUserName);
    }

    /**
     * 判断传入的数据是否为空
     * 查询答案是否与问题及用户名匹配
     *
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @Override
    public HigherResponse forgetCheckAnswer(String username, String question, String answer) {
        if (!StringUtils.isNotBlank(username)) {
            return HigherResponse.getResponseFailed("用户名不能为空。");
        }
        if (!StringUtils.isNotBlank(question)) {
            return HigherResponse.getResponseFailed("问题不能为空。");
        }
        if (!StringUtils.isNotBlank(answer)) {
            return HigherResponse.getResponseFailed("答案不能为空。");
        }
        int i = um.queryUserAnswerIsExits(username, question, answer);
        if (1 > 0) {
            String uuid = UUID.randomUUID().toString();
            GuavaCache.putCache(Const.TOKENCOCHE, uuid);
            return HigherResponse.getResponseSuccess("验证成功。", uuid);
        }
        return HigherResponse.getResponseFailed("回答错误。");
    }

    @Override
    public HigherResponse forgetresetpassword(String username, String newpsw, String token) {
        //判断是否为空
        if (!StringUtils.isNotBlank(username)) {
            return HigherResponse.getResponseFailed("用户名不能为空。");
        }
        if (!StringUtils.isNotBlank(newpsw)) {
            return HigherResponse.getResponseFailed("新密码不能为空。");
        }
        if (!StringUtils.isNotBlank(token)) {
            return HigherResponse.getResponseFailed("token不能为空。");
        }
        //缓存中的token是否过期
        String cache = GuavaCache.getCache(Const.TOKENCOCHE);
        if (StringUtils.equals(token, cache)) {
            int i = um.updateUserPswByUserName(username, newpsw);
            if (i > 0) {
                return HigherResponse.getResponseSuccess("修改密码成功。");
            } else {
                return HigherResponse.getResponseFailed("token无效或过期。");
            }
        }
        return HigherResponse.getResponseFailed("修改密码失败。");
    }

    @Override
    public HigherResponse ResetPassword(HttpSession session, String oldpsw, String newpsw) {
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if (null == user) {
            return HigherResponse.getResponseFailed("未登录。登录后重试。");
        }

        if (!StringUtils.isNotBlank(oldpsw)) {
            return HigherResponse.getResponseFailed("旧密码不能为空。");
        }
        if (!StringUtils.isNotBlank(newpsw)) {
            return HigherResponse.getResponseFailed("新密码不能为空。");
        }
        //旧密码和新密码不能一致
        if (StringUtils.equals(oldpsw, newpsw)) {
            return HigherResponse.getResponseFailed("新旧密码不能一致。");
        }
        //判断旧密码是否正确
        if (!StringUtils.equals(oldpsw, user.getPassword())) {
            return HigherResponse.getResponseFailed("旧密码输入有误。");
        }
        //更改密码
        int i = um.updateUserPswByUserName(user.getUsername(), newpsw);
        if (i > 0) {
            user.setPassword(newpsw);
            session.setAttribute(Const.CURRENTUSER, user);
            return HigherResponse.getResponseSuccess("修改密码成功。");
        }
        return HigherResponse.getResponseFailed("修改密码失败。");
    }

    @Override
    public HigherResponse Update_Information(HttpSession session, User user) {
        //判断是否登录
        User loginUser = (User) session.getAttribute(Const.CURRENTUSER);
        if (null == loginUser) {
            return HigherResponse.getResponseFailed("未登录。");
        }
        int i = um.updateByPrimaryKeySelective(user);
        if (i > 0) {
            return HigherResponse.getResponseSuccess("修改成功。");
        }
        return HigherResponse.getResponseFailed("修改失败。");
    }

    //检查用户名和邮箱是否有效
    public HigherResponse checkValId(String val, String type) {
        if (!StringUtils.isNotBlank(val)) {
            return HigherResponse.getResponseFailed("请输入对应的值。");
        }
        if (StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(type)) {
                int i = um.selectUserByUsername(val);
                if (i > 0) {
                    return HigherResponse.getResponseFailed("用户名已存在。");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int i = um.selectEmailIsExits(val);
                if (i > 0) {
                    return HigherResponse.getResponseFailed("邮箱已存在。");
                }
            }
        } else {
            return HigherResponse.getResponseFailed("校验类型有误。");
        }
        return HigherResponse.getResponseSuccess("校验通过。");
    }

}
