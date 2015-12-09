package com.zhou.controller;

import com.zhou.model.User;
import com.zhou.service.Userservice;
import com.zhou.util.BaseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by icepoint1999 on 12/7/15.
 */

@Controller
public class UserController extends BaseUtil{

    @Resource
    private  Userservice userservice;


//登陆
    @RequestMapping("/login.do")
@ResponseBody
    public Map<String,String> login(Model model,User user,HttpSession httpSession){
        Map<String,String> map=new HashMap<String, String>();
        String path="welcome/index.jsp";
        String RedirectPath="/home.do";
        BaseModel(model,path);

       if( userservice.getUserByinfo(user)!=null){

           map.put("result","success");
           User login_user=userservice.getUserByinfo(user);
           httpSession.setAttribute("user",login_user);
       }else{


           map.put("result","账号或者密码错误");

       }

        map.put("redirect",RedirectPath);


        return map;

    }

//    注册

    @RequestMapping("/signup.do")
    @ResponseBody
    public ModelAndView signup(Model model,User user,HttpSession httpSession){

        String path="welcome/index.jsp";

        BaseModel(model,path);

        userservice.insertUser(user);

        httpSession.setAttribute("user",user);

        return BaseView();



    }

//  登出
    @RequestMapping("/signout.do")
    public ModelAndView signout(HttpSession httpSession){

        httpSession.removeAttribute("user");
        ModelAndView map=new ModelAndView("redirect:/");
        return map;
    }

    @RequestMapping("/user/show.do")
    public ModelAndView ShowProfile(Model model){

        String path="/user/show.jsp";

        BaseModel(model ,path);

        model.addAttribute("current_user",current_user());

        return BaseView();

    }

    @RequestMapping("/user/edit.do")

    public ModelAndView EditProfile(Model model){

        String path="/user/edit.jsp";
        BaseModel(model ,path);

        return BaseView();

    }

}
