package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/diaodu")
public class TestDiaoDuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("index.jsp").forward( request , response );

        request.getRequestDispatcher("index.jsp").include( request , response );
    }
}
