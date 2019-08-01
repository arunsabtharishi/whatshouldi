package com.dragonfly.whatshouldi.controller;

import java.time.LocalTime;

import com.dragonfly.whatshouldi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    LoginService loginService;

    @GetMapping("/welcome")
    public String welcome() {
        loginService.isLoginSuccessFull("bob","saltedValue");
        System.out.println("Hit");
        return "Welcome to what should i Spring boot !!!  ,Time : "+LocalTime.now();
    }
}
