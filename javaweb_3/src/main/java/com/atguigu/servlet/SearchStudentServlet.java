package com.atguigu.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 21:57
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取请求的参数
        //2:发sql语句查询学生的信息
        List<Student> studentList =new ArrayList<Student>();
        for (int i = 0; i <10 ; i++) {
            int t=i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));

            
        }
        //3:保存查询到的结果到request域中
        req.setAttribute("stuList",studentList);
        //4：请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
