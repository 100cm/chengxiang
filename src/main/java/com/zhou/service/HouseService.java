package com.zhou.service;

import com.zhou.mapper.Housemapper;
import com.zhou.model.House;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by icepoint1999 on 12/7/15.
 */

@Service
public class HouseService {

@Resource
    Housemapper housemapper;


    public List<House> getHouseList(){


        return housemapper.getHouses();
    }

    public void InsertHouse(House house){


        housemapper.InsertHouse(house);
    }
    public void DeleteHouseByid(int id){

        housemapper.deleteHouse(id);
    }

    public House Find_by_id(int id){


        return housemapper.findHouseById(id);
    }

    public void Update(House house){

      housemapper.UpdateHouseById(house);

    }

    public void setEmpty(int id){

        housemapper.setEmpty(id);
    }

    public List<House> find_empty_house(){


        return housemapper.find_empty_house();
    }

    public void setNotEmpty(int id){

        housemapper.setNotEmpty(id);
    }

    public void setBorrowed(int id ,Date starttime,Date endtime,String borrowerid){


        housemapper.setBorrowed(id,starttime,endtime,borrowerid);

    }

}
