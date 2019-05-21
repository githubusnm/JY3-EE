package com.neuedu.servlet;

import com.neuedu.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "HelloServlet", urlPatterns = "/Hello.do")
public class HelloServlet extends HttpServlet {

    private UserDAOimpl ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDAOimpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String jiamiusername = ud.jiami(username);
        String jiamipassword = ud.jiami(password);
        User user = new User(jiamiusername, jiamipassword);
        boolean byUsername = ud.findByUsername(jiamiusername);
        if (byUsername == false) {
            ud.insert(user);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }
}
