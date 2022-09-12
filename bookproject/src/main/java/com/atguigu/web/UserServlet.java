package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/17 21:48
 */

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * @param req
     * @param resp
     * @description: 验证用户名是否可用
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/12 21:20
     */

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用UserService.existsUsername()
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果 封装成map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);
        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        resp.getWriter().println(resultMapJsonString);
    }


    /**
     * @param req
     * @param resp
     * @description: 用户登录
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/1 23:14
     */

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1：获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2:调用UserService 处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于 null,说明登陆失败，
        if (loginUser == null) {
            System.out.println("success false");
            //把错误信息，和回显 的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳回到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            System.out.println("success true");
            //保存用户登录的信息到session 域中
            req.getSession().setAttribute("user", loginUser);
            //登录成功，页面跳转到登录成功页
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);


        }
    }

    /**
     * @param req
     * @param resp
     * @description: 用户注销
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/1 23:13
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:销毁session 中用户登录信息
        req.getSession().invalidate();
        //2：重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());

    }

    /**
     * @param req
     * @param resp
     * @description: 用户注册
     * @param:
     * @return: void
     * @author lipeng
     * @date: 2022/9/3 15:12
     */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        /**
         * *BeanUtils 工具类，它可以一次性的把所有请求的参数注入到 JavaBean 中。
         *  BeanUtils 工具类，经常用于把 Map 中的值注入到 JavaBean 中，或者是对象属性值的拷贝操作
         *
         * */


//        User user = new User();
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()){
//            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
//
//        }
//        WebUtils.copyParamToBean(req.getParameterMap(), user);
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        //2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)) {
            //3、检查 用户名是否可用
            if (userService.existsUsername(username)) {


                System.out.println("用户名" + username + "已存在");
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);


            } else {
//               调用Sservice保存到数据库
                userService.registerUser(new User(null, username, password, email));
                //        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }
        } else {
            //把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误!!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //验证码不正确
            System.out.println("验证码错误" + code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
