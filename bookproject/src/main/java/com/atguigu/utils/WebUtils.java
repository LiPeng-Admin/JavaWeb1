package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 22:48
 */
public class WebUtils {
    public static <T>T copyParamToBean(Map value, T bean) {
        try {

            System.out.println("注入之前："+bean);
            /*

             *把所有的请求参数到注入到bean
             * */
            BeanUtils.populate(bean,value);
            System.out.println("注入之后："+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//           e.printStackTrace();
        }
        return defaultValue;
    }
}
