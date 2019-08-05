package com.dragonfly.whatshouldi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragonfly.whatshouldi.service.PreferenceSearchService;

@RestController
@RequestMapping("/users")
public class UserSearchFrequencyController {

    @Autowired
    private PreferenceSearchService preferenceSearchService;

    @GetMapping("/{userName}/frequency")
    public Map<String, Integer> searchTweet(@PathVariable String userName) {
        return preferenceSearchService.fetchUserPreference(userName);
    }
}
