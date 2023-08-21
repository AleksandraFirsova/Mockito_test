package com.example.mockito_test.services.impl;

import com.example.mockito_test.models.User;
import com.example.mockito_test.services.UserDao;
import com.example.mockito_test.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUserExist(User user) {
        return userDao.findAllUsers().contains(user);
    }
}
