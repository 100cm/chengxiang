package com.zhou.service;

import com.zhou.mapper.Usermapper;
import com.zhou.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional

public class Userservice {


    @Resource
    private Usermapper usermapper;

    public User getUserUsingUid(int id) {
        return usermapper.getUserUsingUid(id);
    }

    public void insertUser(User user){

      usermapper.insertUser(user);
    }

    public User getUserByinfo(User user){


        return usermapper.getUserByinfo(user);
    }




}
