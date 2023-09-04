package com.example.mockito_test;

import com.example.mockito_test.models.User;
import com.example.mockito_test.services.UserDao;
import com.example.mockito_test.services.impl.UserDaoImpl;
import com.example.mockito_test.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserDaoImpl mock;

    @InjectMocks
    UserServiceImpl out;

    private static final List<User> USER_LIST =
            new ArrayList<>(Arrays.asList(
                    new User("Name_first", "email.ru"),
                    new User("Name_second", "email.com")));
    private static final List<User> INCORRECT_USER_LIST =
            new ArrayList<>(Arrays.asList(
                    new User("Incorrect_Name_first", "incorrectemail.ru"),
                    new User("Incorrect_Name_second", "incorrectemail.com")));

  //  private static final UserDaoImpl mock = Mockito.mock(UserDaoImpl.class);

    @BeforeEach
    public void createNewUser() {
        out = new UserServiceImpl(mock);
    }

    @Test
    public void checkUserExistTrue() {
        when(mock.findAllUsers()).thenReturn(USER_LIST);
        Assertions.assertTrue(out.checkUserExist(USER_LIST.get(1)));
    }

    @Test
    public void checkUserExistFalse() {
        when(mock.findAllUsers()).thenReturn(USER_LIST);
        Assertions.assertFalse(out.checkUserExist(INCORRECT_USER_LIST.get(0)));
    }
}
