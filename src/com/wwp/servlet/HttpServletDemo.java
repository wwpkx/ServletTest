package com.wwp.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class HttpServletDemo extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init(config)");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}

	@Override
    ////子类不能抛比父类更多的异常
    //public void service(ServletRequest req, ServletResponse res) throws IOException {
    //public void service(ServletRequest req, ServletResponse res) throws Exception { //wrong
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getOutputStream().write("hello servlet!!".getBytes());
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy()");
	}
}
