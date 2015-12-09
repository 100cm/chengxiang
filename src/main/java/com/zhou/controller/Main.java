package com.zhou.controller;


import com.zhou.service.Userservice;
import com.zhou.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by icepoint1999 on 12/5/15.
 */

@Controller
public class Main extends BaseUtil{

    @Resource
    private Userservice userService;
    @RequestMapping("/test.do")

    public void test(){

      System.out.print(userService.getUserUsingUid(1).getUsername());


    }

    @RequestMapping("/welcome.do")

    public ModelAndView welcome(Model model){

        ModelAndView modelAndView=new ModelAndView("/user/login");

        return modelAndView;

    }

    @RequestMapping("/home.do")
    public ModelAndView home(Model model){

        String path="welcome/index.jsp";

        BaseModel(model ,path);

        return BaseView();




    }


}
