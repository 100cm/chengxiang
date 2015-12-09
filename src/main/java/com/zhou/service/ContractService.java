package com.zhou.service;

import com.zhou.mapper.ContractMapper;
import com.zhou.model.Contract;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by icepoint1999 on 12/8/15.
 */
@Service

public class ContractService {

@Resource

ContractMapper contractMapper;

    public void insertContract(Contract contract){

        contractMapper.insertCon(contract);

    }
    public List<Contract> find_all_contract(){

        return contractMapper.FindAllContract();

    }

    public List<Contract> find_out_time_contract(){


        return contractMapper.findouttime();
    }

    public void update_pass_status(int status, int id){

        contractMapper.updatepass(status,id);

    }

    public void update(Contract contract){


        contractMapper.update(contract);
    }

    public Contract find_by_id(int id){


        return contractMapper.find_by_id(id);
    }

    public void delete_by_id(int id){


        contractMapper.delete_by_id(id);
    }

    public List<Contract> find_jiaozu(){

      return  contractMapper.find_jiaozu();
    }

    public void update_pay(int id){

        contractMapper.uupdate_pay(id);
    }

}
