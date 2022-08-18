package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author lipeng
 * @version 1.0
 * @description:
 * 文件下载
 * @date 2022/8/14 23:20
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取要下载的文件名
        String downloadFileName = "女孩.webp";
        //2:读取要下载的文件内容(通过ServletContext 对象可以读取)
        ServletContext servletContext = getServletContext();

        //获取要下载文件的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型：" + mimeType);
        //4:在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5:还要告诉客户端收到的数据是用于下载使用（使用响应头）
        //Content-Disposition,响应头，表示收到的数据怎的处理
        //attachment:表示附件
        //filename:表示要下载的文件名
        //url编码是把汉字转换成%xx%xx的格式
        String ua=req.getHeader("User-Agent");
        //判断是否是火狐浏览器
         if(ua.contains("Firefox"))
         {//使用下面的格式进行BASE64编码后
            String str="attachment;fileName="+"=?utf-8?B?"+new BASE64Encoder().encode("中文.jpg".getBytes("utf-8"))+"?=";
            //设置到响应头中
             resp.setHeader("Content-Disposition",str);
         }
         else
         {//把中文名进行UTF-8编码操作。


        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));}


        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //3:把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
