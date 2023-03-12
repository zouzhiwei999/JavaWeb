package com.atguigu.servlet;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/23 22:51
 */

public class Base64Test {
    
    @Test
    public void test1(){

        //内容
        String content = "这是要编码的内容";
        //获取一个编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //开始编码,需要数组byte
        String encode = null;
        try {
            encode = base64Encoder.encode(content.getBytes("UTF-8"));
            System.out.println(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //获取一个解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //开始解码
        byte[] bytes = new byte[0];
        try {
            bytes = base64Decoder.decodeBuffer(encode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String s = new String(bytes, "UTF-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
