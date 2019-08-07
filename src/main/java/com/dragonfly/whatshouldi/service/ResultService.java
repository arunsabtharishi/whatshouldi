package com.dragonfly.whatshouldi.service;

import com.dragonfly.whatshouldi.requests.ResultRequest;

import java.util.List;

public interface ResultService {
    ResultRequest getResults(String userName, String searchKey);

    List<String> getResultsBasedOnTags(String userName, String searchKey, String tag);
}
