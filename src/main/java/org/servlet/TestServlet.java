package org.servlet;

import javax.jws.WebService;
import javax.servlet.*;
import java.io.IOException;


public class TestServlet implements Servlet {
    static {
        System.out.println("静态代码块执行");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法执行");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法执行");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行");
    }
}
