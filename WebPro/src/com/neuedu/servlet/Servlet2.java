package com.neuedu.servlet;

import com.neuedu.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet2",urlPatterns="/login.do")
public class Servlet2 extends HttpServlet {

    private UserDAOimpl ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDAOimpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginusername = request.getParameter("loginname");
        String loginpassword = request.getParameter("loginpassword");
        String jiamiusername = ud.jiami(loginusername);
        String jiamipassword = ud.jiami(loginpassword);
        User user = new User(jiamiusername,jiamipassword);
        boolean byUsername = ud.findAll(user);
        if (byUsername == true){
            request.setAttribute("username", loginusername);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }
}
