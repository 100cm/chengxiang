package com.zhou.service;

import com.zhou.mapper.Commentmapper;
import com.zhou.model.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by icepoint1999 on 12/8/15.
 */
@Service
public class CommentService {


    @Resource
    Commentmapper commentmapper;

    public void insertComment(Comment comment){

        commentmapper.insertComment(comment);

    }

    public List<Comment> findComments(int houseid){

        return commentmapper.findComments(houseid);
    }

}
