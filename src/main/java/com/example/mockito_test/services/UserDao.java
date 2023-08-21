package com.example.mockito_test.services;

import com.example.mockito_test.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao {
    String getUserByName(String name);

    List<User> findAllUsers();
}
