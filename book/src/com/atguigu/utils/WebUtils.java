package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 0:00
 */

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean, value);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, Integer defaultValue){
        if (str == null){
            return defaultValue;
        }
        return Integer.parseInt(str);
    }
}
