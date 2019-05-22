package com.neuedu.servlet;

import com.neuedu.impl.StudentDAOImpl;
import com.neuedu.test.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteServlet",urlPatterns = "/delete.do")
public class deleteServlet extends HttpServlet {

    private StudentDAOImpl sdi;

    @Override
    public void init() throws ServletException {
        sdi = new StudentDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_id = request.getParameter("student_id");
        sdi.delete(student_id);
        response.sendRedirect("select.do");
    }
}
