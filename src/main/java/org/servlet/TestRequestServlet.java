package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/testRequestServlet")
public class TestRequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //http://localhost:8080/Servlet_war/testRequestServlet?name=123
//        System.out.println(request.getServerName()); //localhost
//        System.out.println(request.getRequestURL()); //http://localhost:8080/Servlet_war/testRequestServlet
//        System.out.println(request.getRequestURI()); ///Servlet_war/testRequestServlet
//        System.out.println(request.getProtocol()); //HTTP/1.1
//        System.out.println(request.getQueryString()); //name=123
//        System.out.println("------------------------------------------------");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            System.out.print(name + " :");
//            String value = request.getHeader(name);
//            System.out.print(value);
//            System.out.println();
//        }
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
//            System.out.print(name + ":");
//            if(name.equals("hobbies")){
//                String[] parameterValues = request.getParameterValues(name);
//                System.out.print(Arrays.toString(parameterValues));
//            }else{
//                System.out.print(request.getParameter(name));
//            }
//            System.out.println();
//        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        //迭代map的三种方式
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String,String[]> e:
            entries ) {
            System.out.print(e.getKey()+":");
            String[] value = e.getValue();
            for (String s : value){
                System.out.print(s);
            }
            System.out.println();
        }

        Set<String> strings = parameterMap.keySet();
        for (String s:
             strings) {
            System.out.println(s + ":" + parameterMap.get(s).toString());
        }

        Collection<String[]> values = parameterMap.values();
        for (String[] strings1 : values){
            System.out.println(strings1.toString());
        }
    }
}
