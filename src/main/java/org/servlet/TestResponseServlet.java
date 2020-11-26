package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/response")
public class TestResponseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","image/png");
        //子类可以自动转成父类（向上转型）
        //int  -----> Integer （自动装箱）
        //流使用过后，响应会被结束，就像return一样后面代码不执行
//        Writer writer = response.getWriter();
//        writer.write("哈哈哈");
//        //String 内部是使用 Byte[] 进行存储
//        String string = "啦啦啦";
//        writer.write(string);
//        writer.write(string.toCharArray());
//        writer.flush();
//        writer.close();
        OutputStream outputStream = response.getOutputStream();
        //这里只能使用绝对路径
        InputStream inputStream = new FileInputStream("F:\\java Web开发\\实习培训\\程序代码\\Servlet\\src\\main\\img\\Snipaste_2020-11-25_19-48-37.png");
        //第一种读取方式
//        int j;
//        while ( ( j = inputStream.read() ) != -1) {
//            outputStream.write(j);
//        }
        //设置当前响应头是在线预览（inline），还是在线下载（attachment）
        response.setHeader("content-disposition","attachment;filename=image.png");
        //第二种读取方式
        byte[] bytes = new byte[1<<10];
        int j;
        while ( ( j = inputStream.read(bytes) ) != -1) {
            outputStream.write(bytes,0,j);
        }
        inputStream.close();
        outputStream.close();
    }
}
