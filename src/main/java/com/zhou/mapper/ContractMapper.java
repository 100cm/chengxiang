package com.zhou.mapper;

import com.zhou.model.Contract;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by icepoint1999 on 12/8/15.
 */
@Repository
public interface ContractMapper {


    @Insert("insert into contract(useraid,userbid,useraname,userbname,houseid,info,totalprice,starttime,endtime) values(" +
            "#{contract.useraid},#{contract.userbid},#{contract.useraname},#{contract.userbname},#{contract.houseid},#{contract.info},#{contract.totalprice},#{contract.starttime},#{contract.endtime})")

    public void insertCon(@Param("contract") Contract contract);

    @Select("select * from contract")

    public List<Contract> FindAllContract();

    @Select(" select * from contract  where DATEDIFF(now(), endtime)>1")
    public List<Contract> findouttime();

    @Update("update contract set ispassed =#{status} where id= #{id}")
    public void updatepass(@Param("status") int status ,@Param("id") int id);

    @Update("update contract set starttime=#{contract.starttime} ,endtime=#{contract.endtime},totalprice=#{contract.totalprice},info=#{contract.info} where id=#{contract.id} ")
    public void update(@Param( "contract") Contract contract);

    @Select("select * from contract where id=#{id}")
    public Contract find_by_id(@Param("id") int id);

    @Delete("delete  from contract where id=#{id}")


    public void delete_by_id(@Param("id") int id);


    @Select("select *  from contract where ispassed=1 and ispayed=false")

    public List<Contract> find_jiaozu();

    @Update("update contract set ispayed =true where id=#{id}")

    public void uupdate_pay(@Param("id") int id);
}
