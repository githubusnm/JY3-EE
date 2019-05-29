package com.neuedu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet",urlPatterns = "/ajaxlogin.do")
public class AjaxServlet extends HttpServlet {

    private Ajax a;

    @Override
    public void init() throws ServletException {
        a = new Ajax();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        boolean all = a.findAll(name, password);
        System.out.println("all = " + all);
        if (all == true){
            System.out.println("123");
            response.getWriter().write("true");
            System.out.println(response);
        }
    }
}
