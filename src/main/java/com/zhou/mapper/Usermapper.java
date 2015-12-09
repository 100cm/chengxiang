package com.zhou.mapper;

import com.zhou.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * User Data Access Object.
 * @author icepoint
 */
@Repository
public interface Usermapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    public User getUserUsingUid(@Param("id") int id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    public User getUserUsingUsername(@Param("username")  String username);

    @Insert("insert into users(phone ,email,username, password ) values(#{user.phone} ,#{user.email},#{user.username},#{user.password})")
    public void insertUser(@Param("user") User user);


    @Select("Select * from users where email =#{user.email} and  password= #{user.password}")

    public User getUserByinfo(@Param("user") User user);






}