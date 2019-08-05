package com.dragonfly.whatshouldi.controller;

import com.dragonfly.whatshouldi.service.FaceBookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private FaceBookImpl faceBookImpl;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<String> fetchData() {
    System.out.println("fetch data");
    List<String> searchResults = null;
    // step 1: if eats to be searched in facebook  like then,
    searchResults = faceBookImpl.retrieveFaceBookData();
    return searchResults;
    }

}

