package com.neuedu.controller;

import com.neuedu.entity.Admin;
import com.neuedu.dao.AdminDAO;
import com.neuedu.impl.AdminDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private AdminDAO ad;

    @Override
    public void init() throws ServletException {
        ad = new AdminDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String adminpassword = request.getParameter("adminpassword");
        Admin admin = new Admin(adminname,adminpassword);
        boolean all = ad.findAll(admin);
        if (all == true) {
            request.setAttribute("name", admin.getAdminname());
            request.getRequestDispatcher("select.jsp").forward(request, response);
        } else {
            response.sendRedirect("fail.jsp");
        }
    }
}
