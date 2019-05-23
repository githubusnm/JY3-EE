package com.neuedu.servlet;

import com.neuedu.test.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateViewServlet",urlPatterns = "/updateview.do")
public class updateViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        String student_password = request.getParameter("student_password");
        StudentManager studentManager = new StudentManager(Integer.parseInt(id), Integer.parseInt(student_id), student_name, student_password);
        request.setAttribute("user", studentManager);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
