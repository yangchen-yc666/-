package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/uploadServlet")
@MultipartConfig(location = "C:/test")
//maxFileSize单位使byte
public class UpLoadServlet extends HttpServlet {
    static {
        System.out.println("执行static方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("filename");
        String name = part.getName();
        System.out.println(name);
        String submittedFileName = part.getSubmittedFileName();
        System.out.println(submittedFileName);
        part.write(submittedFileName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new ServletException("get方式不支持文件上传");
    }
}
