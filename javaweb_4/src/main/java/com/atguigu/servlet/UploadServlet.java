package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: 用来处理文件上传
 * @date 2022/8/14 16:39
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletInputStream stream = req.getInputStream();
//        byte[] buffer = new byte[1024000];
//        int read = stream.read(buffer);
//        System.out.println(new String(buffer, 0, read));

        
        //1:先判断上传的数据是否是多段数据，（只有是多段的数据，才是文件上传的）
        if(ServletFileUpload.isMultipartContent(req)){
            //创建DiskFileItemFactory工厂实现类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //解析上传的数据 ，得到每一个表单项FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断，每一个表单项，是普通类型还是上传的文件
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name 属性值"+fileItem.getFieldName());
                        //参数UTF-8解决乱码问题
                        System.out.println("表单项的value 属性值"+fileItem.getString("UTF-8"));

                    }else{
                        //上传的文件
                        System.out.println("表单项的name 属性值"+fileItem.getFieldName());
                        //参数UTF-8解决乱码问题
                        System.out.println("上传的文件名："+fileItem.getName());
                        fileItem.write(new File("e:\\"+fileItem.getName()));

                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
