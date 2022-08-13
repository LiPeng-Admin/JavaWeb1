创建bookproject
1:先创建书城需要的数据库和表
    CREATE DATABASE book

    USE book;

    CREATE TABLE t_user(
    id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(25) not null UNIQUE,
    password VARCHAR(32) not null,
    email VARCHAR(200)
    )

    DESC t_user;

    INSERT INTO t_user(`username`,`password`,`email`)
    VALUES("admin","admin","admin@atguigu.com")

    SELECT * FROM t_user;

 2:编写数据库表对应的JavaBean对象
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

    }

3:编写工具类 JdbcUtil

    3.1: JDBCUtils创建数据库连接池连接和关闭工具类

    3.2: JDBCUtilsTest 测试

4：编写 BaseDao

5：编写UserDao 和测试
    UserDao 接口
    UserDaoImpl 实现类：
    serDao 测试：

6：编写 UserService 和测
    UserService 接口
    UserServiceImpl 实现类：
    UserService 测试


7、编写 web 层
7.1、实现用户注册的功能
7.1.2、修改 regist.html 和 regist_success.html 页面，修改web.xml文件
7.1.3、编写 RegistServlet 程序


注册业务逻辑
      private UserService userService = new UserServiceImpl();

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //3、检查 用户名是否可用
            if (userService.existsUsername(username)) {


                System.out.println("用户名" + username + "已存在");
//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);


            } else {
//               调用Sservice保存到数据库
                userService.registerUser(new User(null, username, password, email));
                //        跳到注册成功页面 regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);

            }
        } else {
            //验证码不正确
            System.out.println("验证码错误" + code);
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }


    }

8：编写 web 层
  8.1、实现用户登录的功能
  8.1.2、修改 regist.html 和 regist_success.html 页面，修改web.xml文件
  8.1.3、编写 LoginServlet 程序

  登录的业务逻辑
      private UserService userService = new UserServiceImpl();

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  //1：获取请求的参数
          String username = req.getParameter("username");
          String password = req.getParameter("password");
          //2:调用UserService 处理业务
          User loginUser = userService.login(new User(null, username, password, null));
          //如果等于 null,说明登陆失败，
          if(loginUser== null){
              System.out.println("success false");
              //跳回到登录页面
              req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
          }else{
              //登录成功
              System.out.println("success true");
              //登录成功，页面跳转到登录成功页
              req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);



          }

      }
  }

