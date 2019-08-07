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
    public ResultRequest searchResults(@PathVariable String userName, @PathVariable String searchKey) {
        return resultService.getResults(userName, searchKey.toLowerCase());
    }

    @GetMapping("/{userName}/{searchKey}/{tag}")
    public List<String> searchResultsBasedOnTags(@PathVariable String userName, @PathVariable String searchKey, @PathVariable String tag) {
        return resultService.getResultsBasedOnTags(userName, searchKey, tag);
    }

}
