package com.neuedu.controller;

import com.neuedu.dao.UserDAO;
import com.neuedu.entity.User;
import com.neuedu.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/userlogin.do")
public class UserServlet extends HttpServlet {

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
        User user = new User(username, userpassword);
        boolean all = ud.findAll(user);
        if (all == true) {
            request.setAttribute("name", user.getUsername());
            request.getRequestDispatcher("select.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }
}
