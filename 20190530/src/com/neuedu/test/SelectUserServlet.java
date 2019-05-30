package com.neuedu.test;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "SelectUserServlet",urlPatterns = "/selectuser.do")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        User user1 = new User(1,"马云","王英坤非常厉害");
        User user2 = new User(2,"马化腾","王英坤长得帅");
        User user3 = new User(3,"王健林","王英坤最有前途");
        List<User> users = new ArrayList();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
