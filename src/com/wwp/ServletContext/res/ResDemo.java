package com.wwp.ServletContext.res;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

//使用servletContext读取资源文件
//db.properties读取，分别放在了3个地方
//1.web工程主目录
//2.src目录
//3.当前目录
public class ResDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //当前目录，传统读取资源的方式读不到资源文件，因为资源文件生成在WEB-INF/classes目录中
        //test1();

        //src目录：/WEB-INF/classes/db.properties
        test2();
        test3();
        test4();

        //web工程主目录：/db.properties
        test5();
    }

    private void test5() throws IOException {
        System.out.println("test5");
        InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
        System.out.println(in);
    }

    private void test4() throws IOException {
        System.out.println("test4");
        URL url = this.getClass().getClassLoader().getResource("db.properties");
        String path = url.getPath();
        System.out.println(path);
    }

    private void test3() throws IOException {
        System.out.println("test3");

        //获取web资源的绝对路径
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        FileInputStream in = new FileInputStream(path);

        Properties prop = new Properties();
        prop.load(in);

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        System.out.println(path);
    }

    //读取web工程中资源文件的模板代码
    private void test2() throws IOException {
        System.out.println("test2");
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(in);

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        System.out.println(driver);
    }

    public void test1() throws FileNotFoundException {
        //做web工程时，不建议采用传统方式读取文件数据
        System.out.println("test1");
        FileInputStream in = new FileInputStream("db.properties");
        System.out.println(in);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
