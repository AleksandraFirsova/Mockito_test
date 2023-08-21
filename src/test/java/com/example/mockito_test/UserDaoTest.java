package com.example.mockito_test;

import com.example.mockito_test.models.User;
import com.example.mockito_test.services.impl.UserDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoTest {

    private static final String USER_NAME = "Name_first";
    private static final String INCORRECT_USER_NAME = "Incorrect name";

    UserDaoImpl userDao;

    @BeforeEach
    private void createNewUser() {
        userDao = new UserDaoImpl();
    }
    @Test
    void shouldReturnGetUserByName() {
        Assertions.assertEquals(USER_NAME, userDao.getUserByName(USER_NAME));
    }

    @Test
    void shouldReturnNullGetUserByName() {
        Assertions.assertNull(userDao.getUserByName(INCORRECT_USER_NAME));
    }
}
