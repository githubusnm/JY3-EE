package com.neuedu.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Session implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session创建");
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null){
            count = 1;
        }else{
            count++;
        }
        servletContext.setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session销毁");
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        count--;
        servletContext.setAttribute("count", count);
    }
}
