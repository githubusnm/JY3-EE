package com.neuedu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BBBbServlet",urlPatterns = "/BBBb.do")
public class BBBbServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        String email = req.getParameter("email");
        System.out.println("name = " + name);
        if (name.equals("张丽") && password.equals("111111") && password.equals(password1) && email.equals("zhangli@126.com")){
            resp.getWriter().write("true");
        }else {
            resp.getWriter().write("false");
        }
    }
}
