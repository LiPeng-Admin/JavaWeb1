package com.atguigu.util;

import javax.servlet.http.Cookie;

/**
 * @author lipeng
 * @version 1.0
 * @description: 查找指定名称的cookie 对象
 * @date 2022/8/30 8:56
 */
public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }

        }


        return null;

    }

}

