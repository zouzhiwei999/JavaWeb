package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

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
 * @author AOA
 * @version 1.0
 * @description: 客户端 下载 服务器的资源 ,存在web目录下的file文件夹
 * Content-Disposition : 内容配置
 * attachment : 附件
 * URLEncoder.encode : URL编码器.编码
 *
 * @date 2022/4/23 20:47
 */

public class DownloadServlet extends HttpServlet {
    /*
     *  1.获取要访问的文件名,暂时写死为String类型
     * 2.通过SrevletContext对象.getResourceAsStream 获取文件输入流，从web里面的file文件夹里面找
     * 3.获取一个输出流,使用commons-io-1.4.jar下的IOUtils.copy(输入流, 输出流);输出到客户端
     *
     * 4.在第2部之前,获取通过SrevletContext对象获取要返回的文件类型getMimeType，从web里面的file文件夹里面找
     * 5.告诉客户端这是什么类型的内容 resp.setContentType(mimeType);
     * 6.告诉客户端这是下载用的，不让他直接显示到网页
     *
     * @author zzw
     * @date 2022/4/23 21:46
     * @param [req, resp]
     * @return void
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户要下载的文件名
        String file1 = "fish.jpg";

        //读取文件内容
        ServletContext servletContext = getServletContext();

        //获取返回类型
        String mimeType = servletContext.getMimeType("/file/" + file1);
        System.out.println("返回类型" + mimeType);

        //告诉客户端这是什么类型的内容
        resp.setContentType(mimeType);

        //告诉客户端这是下载用的，不让他直接显示到网页
        //内容配置,附件
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("什么几把", "UTF-8"));

        //把读取的文件内容发送到客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + file1);

        ServletOutputStream outputStream = resp.getOutputStream();

        IOUtils.copy(resourceAsStream, outputStream);
    }
}
