package com.neuedu.servlet;

import com.neuedu.impl.StudentDAOImpl;
import com.neuedu.test.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/select.do")
public class StudentServlet extends HttpServlet {

    private StudentDAOImpl sdi;

    @Override
    public void init() throws ServletException {
        sdi = new StudentDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentManager> select = sdi.select();
        req.setAttribute("user", select);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
