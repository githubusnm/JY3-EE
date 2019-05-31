package com.neuedu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BBBServlet",urlPatterns ="/BBB.do")
public class BBBServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<form><table border=\"1px\" style=\"text-liner:center\">\n" +
                "    <tr>\n" +
                "        <td>用户注册</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>用户名：<input type=\"text\" id=\"name\" name=\"name\"></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>密码：<input type=\"password\" id=\"password\' name=\"password\"></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>确认密码：<input type=\"password\" id=\"password1\" name=\"password1\"></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>邮箱：<input type=\"email\" id=\"email\" name=\"email\"></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td><input type=\"submit\" id=\"btn2\" value=\"提交\"></td>\n" +
                "    </tr>\n" +
                "</table></form>");
    }
}
