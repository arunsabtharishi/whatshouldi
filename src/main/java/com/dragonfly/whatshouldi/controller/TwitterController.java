package com.dragonfly.whatshouldi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dragonfly.whatshouldi.service.TwitterService;

@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("/tweet")
    public Tweet welcome() {
        System.out.println("Hit");
        return twitterService.tweet_new();
    }

    @GetMapping("/tweet/search/{searchStr1}")
    public List<Tweet> searchTweet(@PathVariable String searchStr1) {
        return twitterService.searchTweet(searchStr1);
    }
    @GetMapping("/tweet/search/{searchStr1}/{searchStr2}")
    public List<String> searchTweetTwo(@PathVariable String searchStr1, @PathVariable String searchStr2) {
        return twitterService.searchTweetText(searchStr1, searchStr2);
    }
    @GetMapping("/tweet/search/{searchStr1}/{searchStr2}/{searchStr3}")
    public List<Tweet> searchTweetThree(@PathVariable String searchStr1, @PathVariable String searchStr2, @PathVariable String searchStr3) {
        return twitterService.searchTweet(searchStr1, searchStr2, searchStr3);
    }
}
