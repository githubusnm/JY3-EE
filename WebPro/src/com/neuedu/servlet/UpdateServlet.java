package com.neuedu.servlet;

import com.neuedu.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/check.do")
public class UpdateServlet extends HttpServlet {

    private UserDAOimpl ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDAOimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String jiaminewpassword = ud.jiami(newpassword);
        String jiamiusername = ud.jiami(username);
        String jiamipassword = ud.jiami(password);
        User user = new User(jiamiusername, jiamipassword);
        boolean all = ud.findAll(user);
        if (all == true){
            ud.update(jiaminewpassword, jiamiusername);
            request.setAttribute("username", ud.jiemi(jiamiusername));
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }

}
