ch01-hello-springMVC：第一个springMVC项目

需求：
    用户在页面发起一个请求，请求交给springMVC的控制器对象，
    并显示请求的处理结果（在结果页面显示第一个欢迎语句）。

实现步骤：
    1.新建web maven工程
    2.加入依赖
        spring-webmvc依赖，间接的吧spring的依赖都加入到项目中
        jsp，servlet依赖
    3.重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
        1）DispatcherServlet：中央调度器，是一个servlet，父类是继承HttpServlet
        2）DispatcherServlet：也叫做前端控制器（front controller）
        3）DispatcherServlet：负责接收用户提交的请求，调用其他的控制器对象，
                              并把请求的处理结果显示给用户
    4.创建一个发起请求的界面
    5.创建控制器类
        1）在类的上面加入@Controller注解，创建对象，并放入到springmvc容器中
        2）在类中方法上面加入@RequestMapping注解。
    6.创建一个作为结果的jsp，显示请求处理的结果
    7.创建一个springmvc的配置文件（spring的配置文件一样）
        1）声明组件扫描器，指定@Controller注解所在的包名
        2）声明视图解析器，帮助处理视图的。
