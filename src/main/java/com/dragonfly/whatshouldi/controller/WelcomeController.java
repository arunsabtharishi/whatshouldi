package com.dragonfly.whatshouldi.controller;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        System.out.println("Hit");
        return "Welcome to what should i Spring boot !!!  ,Time : "+LocalTime.now();
    }
}
