package com.neuedu.controller;

import com.neuedu.dao.UserDAO;
import com.neuedu.entity.User;
import com.neuedu.impl.UserDAOImpl;
import com.neuedu.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserregisterServlet", urlPatterns = "/userregister.do")
public class UserregisterServlet extends HttpServlet {

    private UserDAO ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        User user = new User(Utils.getRandomId(), username, userpassword);
        boolean b = ud.findUsername(user.getUsername());
        if (b == false) {
            ud.insert(user);
            request.setAttribute("name", user.getUsername());
            response.sendRedirect("select.jsp");
        } else {
            response.sendRedirect("fail.jsp");
        }
    }
}
