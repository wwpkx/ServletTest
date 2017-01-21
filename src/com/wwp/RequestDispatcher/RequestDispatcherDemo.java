package com.wwp.RequestDispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注意：
//1.转发之前的所有写入都无效
//2.转发之前，response不能提交，否则转发的时候服务器会抛：Cannot forward after response has been committed
public class RequestDispatcherDemo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //err 1
        //response.getOutputStream().write("1111".getBytes());

        ServletContext context = this.getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);  //doget()

        //err 2
        //response.getOutputStream().write("4444444444".getBytes());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
