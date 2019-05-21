package com.neuedu.servlet;

import com.neuedu.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/select.do")
public class SelectServlet extends HttpServlet {

    private UserDAOimpl ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDAOimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> selectusers = ud.select();
        request.setAttribute("alluser", selectusers);
        request.getRequestDispatcher("select.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
