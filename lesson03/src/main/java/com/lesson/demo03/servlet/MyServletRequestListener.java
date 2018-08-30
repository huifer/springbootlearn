package com.lesson.demo03.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //销毁的时候请求
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("request in destroyed!");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //初始化的时候请求
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();
        servletContext.log("request in initialized!");
    }
}
