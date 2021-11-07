package com.example.springtx.service;

import com.example.springtx.dao.UserDao;
import com.example.springtx.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertA(User user) {
        userDao.insert(new User(1, "A"));
    }

}
