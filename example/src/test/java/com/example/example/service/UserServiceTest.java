package com.example.example.service;

import com.example.example.service.servicesImpl.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setup(){
        userService = new UserService();
    }

    @Test
    void helloWorldTest(){
        Assertions.assertThat(userService.helloWorld().equalsIgnoreCase("Hello World")).isTrue();
    }
}
