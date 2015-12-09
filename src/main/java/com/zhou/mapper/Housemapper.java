package com.zhou.mapper;

import com.zhou.model.House;
import com.zhou.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by icepoint1999 on 12/7/15.
 */

@Repository
public interface Housemapper {


    @Select("SELECT *  FROM houses ")
    public List<House> getHouses();

    @Insert("insert into houses(avatar,name,postion,ownerid,ownername,price,info,type,size) values(#{house.avatar},#{house.name},#{house.postion}," +
            "#{house.ownerid},#{house.ownername},#{house.price},#{house.info},#{house.type},#{house.size})")
    public void InsertHouse(@Param("house") House house);


    @Delete("delete from houses where id=#{id}")
    public void deleteHouse (@Param("id") int id);

    @Select("select * from houses where id=#{id}")

    public House findHouseById(@Param("id") int id);

    @Update("update houses set name=#{house.name} , price=#{house.price},type=#{house.type},postion=#{house.postion},size=#{house.size}," +
            "ownerid=#{house.ownerid},ownername=#{house.ownername},info=#{house.info} where id=#{house.id} ")

    public void UpdateHouseById(@Param("house") House house);

@Update("update houses set isempty=1 where id=#{id}")

    public void setEmpty(@Param("id") int id);

    @Select("select * from houses where isempty=1")
    public List<House> find_empty_house();


    @Update("update houses set isempty=0 where id=#{id}")
    public  void setNotEmpty(@Param("id") int id);


    @Update("update houses set isborrowed=true,isempty=2,borrowertime=#{borrowtime},borrowerid=#{borrowerid},returntime=#{returntime} where id=#{id}")
    public  void setBorrowed(@Param("id") int id,@Param("borrowtime")Date borrowtime,@Param("returntime") Date returntime,@Param("borrowerid") String borrowerid);




}
