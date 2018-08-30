package com.lesson.demo03.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(
        name = "myServlet",// 名称
        urlPatterns = "/myservlet",// 映射 可多个
        initParams = {
                @WebInitParam(name = "me", value = "servlet")
        }
)
public class MyServlet extends HttpServlet {

    private String value;

    public void init(ServletConfig servletConfig) {
        value = servletConfig.getInitParameter("me");
    }


    /***
     * 定义一个自己的servlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer writer = response.getWriter();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("in servlet");

        writer.write("<html><body>hello servlet</body></html>");
        writer.write("<html><body>==>> "+value+"</body></html>");
    }
}
