package com.neuedu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxregisterServlet",urlPatterns = "/register.do")
public class AjaxregisterServlet extends HttpServlet {

    private Ajax a;

    @Override
    public void init() throws ServletException {
        a = new Ajax();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        boolean byName = a.findByName(name);
        if (byName == false){
            response.getWriter().write("true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
