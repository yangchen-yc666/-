package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/response2")
public class TestResponseServlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置状态码
//        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        //浏览器报错：Failed to load resource: the server responded with a status of 404 ()

//        response.sendError(HttpServletResponse.SC_NOT_FOUND,"资源找不到");
        //重定向的本质
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("location","/Servlet_war/index.jsp");
    }
}
