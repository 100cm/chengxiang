package com.zhou.mapper;

import com.zhou.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by icepoint1999 on 12/8/15.
 */
@Repository
public interface Commentmapper {



    @Select("select * from comments where houseid=#{houseid}")
    public List<Comment> findComments(@Param("houseid") int houseid);


    @Insert("insert into comments(userid ,comment,houseid,username) values (#{comment.userid},#{comment.comment},#{comment.houseid},#{comment.username})")
    public void insertComment(@Param("comment") Comment comment);
}
