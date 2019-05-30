package com.neuedu.test;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HuoquServlet",urlPatterns = "/huoqu.do")
public class HuoquServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");
//        User user1 = new User(1,"张三","123456");
//        User user2 = new User(1,"张三","987654");
//        User user3 = new User(1,"张三","/*-+$%");
//        List<User> users = new ArrayList();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        JSONArray jsonArray = JSONArray.fromObject(users);
//        response.getWriter().write(jsonArray.toString());

//        String name = request.getParameter("name");
//        if (name.equals("user")){
//            response.getWriter().write("1");
//        }else if(name.equals("admin")){
//            response.getWriter().write("2");
//        }else{
//            response.getWriter().write("3");
//        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
