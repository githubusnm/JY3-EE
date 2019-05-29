package com.neuedu.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "LoginFilter",urlPatterns = "*.jsp")
public class LoginFilter implements Filter {

    String allFilter;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String requestURI = request.getRequestURI();
        if ("/index.jsp".equals(requestURI)){
            chain.doFilter(request, response);
            return;
        }

        List<String> strings = Arrays.asList(allFilter.split(","));
        if (strings.contains(requestURI)){
            Object name = request.getSession().getAttribute("name");
            if (name != null){
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
        allFilter = config.getServletContext().getInitParameter("allFilterPage");
        System.out.println("allFilter = " + allFilter);
    }

}
