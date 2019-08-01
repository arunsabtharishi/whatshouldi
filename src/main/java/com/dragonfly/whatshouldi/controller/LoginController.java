package com.dragonfly.whatshouldi.controller;

import com.dragonfly.whatshouldi.login.LoginRequest;
import com.dragonfly.whatshouldi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        return loginService.isLoginSuccessFull(loginRequest.getUserName(),loginRequest.getPassword());
    }
}
