package com.wwp.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//多个servlet通过servletContext实现数据共享
public class ServletContextDemo1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        //获取整个web站点的初始化参数
        String url = context.getInitParameter("url");
        System.out.println(url);

        String data = "data";
        context.setAttribute("data", data);  //map
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
