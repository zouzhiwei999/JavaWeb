package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
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
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/23 17:27
 */

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("图片上传");

//        ServletInputStream inputStream = req.getInputStream();
//        byte[] buffer = new byte[10240000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer, 0, read));

        //1.是否多端数据
        if (ServletFileUpload.isMultipartContent(req)) {

            //FileItemFactory工厂实现类
            FileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            //2.创建解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            //开始解析
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
                        //true,正常表单项
                        System.out.println("name属性:" + fileItem.getFieldName());
                        System.out.println("value属性:" +fileItem.getString("UTF-8"));
                    } else {
                        //false,提交的文件
                        System.out.println("name属性:" + fileItem.getFieldName());
                        System.out.println("文件名:" + fileItem.getName());

                        try {
                            fileItem.write(new File("E:\\" + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

}
