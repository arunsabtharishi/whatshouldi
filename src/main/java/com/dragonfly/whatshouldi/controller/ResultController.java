package com.dragonfly.whatshouldi.controller;

import com.dragonfly.whatshouldi.requests.ResultRequest;
import com.dragonfly.whatshouldi.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    ResultService resultService;

    @GetMapping("/{userName}/{searchKey}")
    public ResultRequest searchTweet(@PathVariable String userName, @PathVariable String searchKey) {
        return resultService.getResults(userName, searchKey);
    }
}
