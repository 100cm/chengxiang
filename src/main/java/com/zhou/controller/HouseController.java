package com.zhou.controller;

import com.zhou.model.Comment;
import com.zhou.model.House;
import com.zhou.model.User;
import com.zhou.service.CommentService;
import com.zhou.service.HouseService;
import com.zhou.service.Userservice;
import com.zhou.util.BaseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by icepoint1999 on 12/7/15.
 */

@Controller
public class HouseController extends BaseUtil{

//    Spring自动注入

    @Resource
    HouseService houseService;

    @Resource
    Userservice userservice;

    @Resource
    CommentService commentService;

//添加房屋页面
    @RequestMapping("/house/add.do")

    public ModelAndView HouseAdd(Model model,House house,HttpServletRequest request){

        String RelativeUrl="house/add.jsp";

        BaseModel(model, RelativeUrl);

        model.addAttribute("RelativeUrl",RelativeUrl);




        return  BaseView();

    }
//新增房屋动作
    @RequestMapping("/house/create.do")
    public ModelAndView HouseCreate(Model model,House house){
        String path="house/add.jsp";

        System.out.print(house.getName());

        BaseModel(model, path);

        int id=house.getOwnerid();
        
        if(userservice.getUserUsingUid(id)!=null){
            model.addAttribute("msg","添加成功");
            house.setOwnername(userservice.getUserUsingUid(id).getUsername());


            houseService.InsertHouse(house);

        }else{

            model.addAttribute("msg","添加失败!用户不存在");

        }
        return BaseView();
    }


//显示所有房屋动作
    @RequestMapping("/house/show_all.do")

    public ModelAndView show(Model model){

        List<House>  houses =houseService.getHouseList();
        model.addAttribute("houses",houses);
        String path="house/show.jsp";

        BaseModel(model ,path);


        return BaseView();
    }

//    删除房屋动作
    @RequestMapping("/house/delete.do")
    @ResponseBody
    public Map<String ,String> delete(int id){


        Map<String,String> map=new HashMap<String, String>();

        houseService.DeleteHouseByid(id);

        map.put("path","/house/show_all.do");

        return map;

    }

    //设置空房子

    @RequestMapping("/house/empty.do")

    @ResponseBody
    public Map<String,String> empty(int id){
        Map<String,String> map=new HashMap<String, String>();
        House house =houseService.Find_by_id(id);

        if (house.getIsempty()==0){

            houseService.setEmpty(id);
            map.put("path","/house/show_all.do");

        }else if(house.getIsempty()==1){


            map.put("msg","请勿重复设置");
        }
        else  if(house.getIsempty()==2)
        {
            map.put("msg","请不要设置已出租房子");

        }

        return map;



    }



//    修改房屋信息动作
    @RequestMapping("/house/edit.do")

    public ModelAndView edit(int id,Model model,String msg,String msg2)  {
        if (msg!=null){

    model.addAttribute("msg","修改成功");

}else if(msg2!=null){

    model.addAttribute("msg","修改失败");

}model.addAttribute("house",houseService.Find_by_id(id));

        String path="/house/edit.jsp";
        BaseModel(model ,path);

        return BaseView();


    }

    @RequestMapping("/house/update.do")

    public ModelAndView update(House house,Model model){
        ModelAndView mav=new ModelAndView("redirect:/house/edit.do?id="+house.getId());

        if (userservice.getUserUsingUid(house.getOwnerid())!=null){

            house.setOwnername(userservice.getUserUsingUid(house.getOwnerid()).getUsername());
            houseService.Update(house);
            model.addAttribute("msg","修改成功");
        }else{

            model.addAttribute("msg2","修改失败，拥有人不存在");

        }
        return mav;

    }


    @RequestMapping("/house/show_empty.do")
    public ModelAndView show_empty(Model model){
        String path="/house/empty.jsp";

        BaseModel(model ,path);

        model.addAttribute("houses",houseService.find_empty_house());

        return BaseView();
    }

    @RequestMapping("/house/not_empty.do")
    @ResponseBody
    public Map<String,String> not_empty(int id){


        Map<String,String> map=new HashMap<String, String>();
        House house =houseService.Find_by_id(id);



            houseService.setNotEmpty(id);
            map.put("path","/house/show_empty.do");



        return map;



    }

    @RequestMapping(value="/house/{id}/show.do")

    public ModelAndView show(@PathVariable(value="id") int id,Model model){

        String path="house/index.jsp";
        List<Comment> commentlist=commentService.findComments(id);

        BaseModel(model,path);

        House house=houseService.Find_by_id(id);

        User user=userservice.getUserUsingUid(house.getOwnerid());



       model.addAttribute("house",house);
        model.addAttribute("house_owner",user);
        model.addAttribute("comments",commentlist);
        return BaseView();
    }
    @RequestMapping("/house/comment.do")
    @ResponseBody
    public Map<String ,String> comment(String comment,int houseid,HttpSession session){
        Comment comment1=new Comment();
        comment1.setComment(comment);
        comment1.setHouseid(houseid);
        User current_user= (User) session.getAttribute("user");
        comment1.setUserid(current_user.getId());
        comment1.setUsername(current_user.getUsername());
        commentService.insertComment(comment1);
        System.out.print(comment);
        Map<String,String> map=new HashMap<String, String>();
        map.put("path","/house/"+houseid+"/show.do");
        return map;


    }



}
