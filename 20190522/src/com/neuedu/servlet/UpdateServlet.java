package com.neuedu.servlet;

import com.neuedu.dao.StudentDAO;
import com.neuedu.impl.StudentDAOImpl;
import com.neuedu.test.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update.do")
public class UpdateServlet extends HttpServlet {

    private StudentDAO sm;

    @Override
    public void init() throws ServletException {
        sm = new StudentDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_name = request.getParameter("student_name");
        String student_id = request.getParameter("student_id");
        sm.update(student_name, student_id);
        response.sendRedirect("select.do");
    }
}
