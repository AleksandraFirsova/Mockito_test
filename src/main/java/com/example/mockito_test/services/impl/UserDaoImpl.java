package com.example.mockito_test.services.impl;

import com.example.mockito_test.exceptions.UserNotFoundException;
import com.example.mockito_test.models.User;
import com.example.mockito_test.services.UserDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    private List<User> userList;

    public UserDaoImpl() {
        this.userList = new ArrayList<>(Arrays.asList(
                new User("Name_first", "email.ru"),
                new User("Name_second", "email.com")
        ));
    }

    @Override
    public String getUserByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user.getName();
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        if (userList.isEmpty()) {
            throw new UserNotFoundException("Users not found");
        } else {
            return userList;
        }
    }
}
