package com.dlkyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dlkyy on 2021/3/6 16:00
 *
 * @ controller：创建处理器对象，对象放在springmvc容器中
 *   位置：在类的上面
 *   和spring中的@Service，@Component一样
 *
 *   能处理请求的都是控制器（处理器）：
 *        MyController能处理请求，叫做后端控制器（back controller）
 */
@Controller
public class MyController {
  /**
   * 处理用户提交的请求，springmvc中是使用方法来处理的
   * 方法是自定义额，可以有多种返回值，多种参数，方法名称自定义
   *
   * 准备使用doSome方法处理some.do请求
   * @RequestMapping: 请求映射，作用是吧一个请求地址和一个方法绑定在一起。
   *                  一个请求指定一个方法处理。
   *     属性：1.value 是一个String，表示请求的uri地址（some.do）
   *            value的值必须是唯一的，不能重复。在使用时，推荐地址以“/”
   *     位置：1.在方法的上面，常用的。
   *          2.在类的上面
   *   说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法。
   *   使用@RequestMapping修饰的方法可以处理请求的，类似Servlet中的doGet，doPost
   *
   * @return ModelAndView 表示本次请求的处理结果
   *         Mode：数据，请求处理完成后，要显示给用户的数据
   *         view：视图，比如jsp等等
   */
  @RequestMapping(value = "/some.do")
  public ModelAndView doSome(){ // doGet()--service请求处理
    // 处理some.do请求

    ModelAndView mv = new ModelAndView();
    // 添加数据，框架在请求的最后把数据放入到request作用域。
    // request.setAttribute("msg", "hello springmvc！")
    mv.addObject("msg", "hello springmvc！");
    mv.addObject("fun","do doSome!");

    // 指定视图，指定视图的完整路径
    // 框架对视图的操作执行forward操作，
    // 相当于：request.getRequestDispatcher("/show.jsp").forward(request,response)
    // mv.setViewName("/show.jsp");
    // mv.setViewName("/WEB-INF/view/show.jsp");

    // 当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
    // 框架会使用视图解析器的前缀 + 逻辑名称 + 后缀组成完整路径，这里就是字符串的连接操作
    mv.setViewName("show");
    // 返回
    return mv;
  }
}
