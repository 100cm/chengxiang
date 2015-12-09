package com.zhou.controller;

import com.zhou.model.Contract;
import com.zhou.model.House;
import com.zhou.service.ContractService;
import com.zhou.service.HouseService;
import com.zhou.service.Userservice;
import com.zhou.util.BaseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by icepoint1999 on 12/8/15.
 */

@Controller
public class ContractController extends BaseUtil{

    @Resource
    Userservice userservice;

    @Resource
    HouseService houseService;

    @Resource
    ContractService contractService;


@RequestMapping("/contract/create.do")


    public ModelAndView create(int useraid,int userbid,int houseid,String starttime,String endtime,int totalprice,String info,  Model model) throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
    Date startdate = sdf.parse(starttime);
    Date enddate =sdf.parse(endtime);

    if(userservice.getUserUsingUid(useraid)!=null){

        if(houseService.Find_by_id(houseid)!=null){


            if(houseService.Find_by_id(houseid).getOwnerid()==useraid){


               if(userservice.getUserUsingUid(userbid)!=null){

                   if(houseService.Find_by_id(houseid).getIsborrowed()==null){



                       Contract contract=new Contract();
                       contract.setUseraid(useraid);
                       contract.setUserbid(userbid);
                       contract.setUseraname(userservice.getUserUsingUid(useraid).getUsername());
                       contract.setUserbname(userservice.getUserUsingUid(userbid).getUsername());
                       contract.setInfo(info);
                       contract.setHouseid(houseid);
                       contract.setStarttime(startdate);
                       contract.setEndtime(enddate);
                       contract.setTotalprice(totalprice);


                       contractService.insertContract(contract);

                       houseService.setBorrowed(houseid,startdate,enddate, String.valueOf(userbid));
                       model.addAttribute("msg","添加成功!");
                   }else{
                       model.addAttribute("msg","该房子已被出租");

                   }


               }

            }else{

                model.addAttribute("msg","用户没有该房子");
            }

        }else{

            model.addAttribute("msg","房子不存在");
        }

    }else{

        model.addAttribute("msg","用户不存在 ");

    }

    String path="/contract/index.jsp";
    BaseModel(model,path);
    return  BaseView();


}


    @RequestMapping("/contract/new.do")

    public ModelAndView new_c(Model model){

        String path="/contract/index.jsp";
        BaseModel(model ,path);

        return BaseView();

    }

    @RequestMapping("/contract/show_all.do")

    public ModelAndView show_all(Model model){

        String path="/contract/show_all.jsp";

        List<Contract> contracts =contractService.find_all_contract();
        model.addAttribute("contracts",contracts);
        BaseModel(model, path);

        return BaseView();


    }

    @RequestMapping("/contract/pass.do")
    @ResponseBody
    public Map<String,String> pass(Model model,int id){

        Map<String,String> map=new HashMap<String, String>();

        contractService.update_pass_status(1,id);

        map.put("path","/contract/show_all.do");


        return map;
    }
    @RequestMapping("/contract/refuse.do")
    @ResponseBody
    public Map<String,String> refuse(Model model,int id){

        Map<String,String> map=new HashMap<String, String>();

        contractService.update_pass_status(2,id);

        map.put("path","/contract/show_all.do");


        return map;
    }


    @RequestMapping("/contract/update.do")


    public ModelAndView update(int id,int useraid,int userbid,int houseid,String starttime,String endtime,int totalprice,String info,  Model model) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
        Date startdate = sdf.parse(starttime);
        Date enddate =sdf.parse(endtime);

        if(userservice.getUserUsingUid(useraid)!=null){

            if(houseService.Find_by_id(houseid)!=null){


                if(houseService.Find_by_id(houseid).getOwnerid()==useraid){


                    if(userservice.getUserUsingUid(userbid)!=null){
                        if(houseService.Find_by_id(houseid).getIsborrowed()==null){

                            Contract contract=new Contract();
                            contract.setUseraid(useraid);
                            contract.setUserbid(userbid);
                            contract.setUseraname(userservice.getUserUsingUid(useraid).getUsername());
                            contract.setUserbname(userservice.getUserUsingUid(userbid).getUsername());
                            contract.setInfo(info);
                            contract.setHouseid(houseid);
                            contract.setStarttime(startdate);
                            contract.setEndtime(enddate);
                            contract.setTotalprice(totalprice);


                            contractService.insertContract(contract);

                            houseService.setBorrowed(houseid,startdate,enddate, String.valueOf(userbid));
                            model.addAttribute("msg","添加成功!");
                            Contract contract1=contractService.find_by_id(id);

                            model.addAttribute("contract",contract);
                        }
                        else{
                            model.addAttribute("msg","该房子已被出租");

                        }


                    }

                }else{

                    model.addAttribute("msg","用户没有该房子");
                }

            }else{

                model.addAttribute("msg","房子不存在");
            }

        }else{

            model.addAttribute("msg","用户不存在 ");

        }

        String path="/contract/edit.jsp";
        BaseModel(model,path);
        return  BaseView();


    }

    @RequestMapping("/contract/edit.do")

    public ModelAndView edit(Model model,int id){

        Contract contract =contractService.find_by_id(id);

        model.addAttribute("contract" ,contract);
        String path="/contract/edit.jsp";

        BaseModel(model,path);

        return BaseView();


    }

    @RequestMapping("/contract/timeout.do")
public ModelAndView timeout(Model model){

        List<Contract> contracts =contractService.find_out_time_contract();

        model.addAttribute("contracts",contracts);
        String path="/contract/timeout.jsp";
        BaseModel(model,path);

        return BaseView();




    }

    @RequestMapping("/contract/delete.do")

    @ResponseBody
    public Map<String,String> delete(Model model ,int id){

        contractService.delete_by_id(id);

        Map<String ,String> map=new HashMap<String, String>();

        map.put("path","/contract/timeout.do");


        return map;

    }

    @RequestMapping("/contract/show_pay.do")

    public ModelAndView show_pay(Model model){
        String path="/contract/show_pay.jsp";
      List<Contract>  contracts= contractService.find_jiaozu();

        BaseModel(model,path);

        model.addAttribute("contracts",contracts);


        return BaseView();

    }

    @RequestMapping("/contract/pay.do")
    @ResponseBody

    public Map<String,String> pay(int id ,Model model){


        String path="/contract/show_pay.do";


        contractService.update_pay(id);

        Map<String,String> map=new HashMap<String, String>();


        map.put("path",path);
        return map;

    }





}
