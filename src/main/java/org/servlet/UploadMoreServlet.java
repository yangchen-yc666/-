package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/uploadMoreServlet")
@MultipartConfig(location = "C:/test")
public class UploadMoreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Collection<Part> parts = request.getParts();
        for (Part part :
                parts) {
            String submittedFileName = part.getSubmittedFileName();
            System.out.println(submittedFileName);
            part.write(submittedFileName);
        }
    }
}
