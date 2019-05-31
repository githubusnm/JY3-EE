package com.neuedu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AAAServlet",urlPatterns = "/selectAAA.do")
public class AAAServlet extends HttpServlet {

    private Select s;

    @Override
    public void init() throws ServletException {
        s = new Select();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean all = s.findAll(name, password);
        System.out.println("all = " + all);
        if (all==true){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
