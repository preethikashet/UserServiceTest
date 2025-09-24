package com.example.service;

import com.example.dao.UserDAOPreethika;
import com.example.entity.UserEntityPreethika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicePreethika {

    @Autowired
    private UserDAOPreethika userDAOPreethika;

    public UserEntityPreethika addUserPreethika(UserEntityPreethika user)
    {
        return userDAOPreethika.save(user);
    }
    public UserEntityPreethika getUserByIdPreethika(int id)
    {
        return userDAOPreethika.findById(id).get();
    }
}
