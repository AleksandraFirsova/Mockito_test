package com.example.mockito_test.services;

import com.example.mockito_test.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean checkUserExist(User user);
}
