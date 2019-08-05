package com.dragonfly.whatshouldi.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.GeoCode;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.dragonfly.whatshouldi.twitter.TwitterTemplateCreator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TwitterService {

    @Autowired
    private TwitterTemplateCreator twitterCreator;

    public Tweet tweet(Twitter twitter, String tweetText) {
        try {

            SearchResults results = twitter.searchOperations().search("#spring", 2);
            List<Tweet> list = results.getTweets();

            return twitter.timelineOperations().updateStatus(tweetText);
        } catch (RuntimeException ex) {
            log.error("Unable to tweet" + tweetText, ex);
        }
        return null;
    }

    public Tweet tweet_new() {
        Twitter twitterTemplate = twitterCreator.getTwitterTemplate("SpringAtSO");
        return tweet(twitterTemplate, "First Tweet");
    }


    public List<Tweet> searchTweet(Twitter twitter, String... searchStr) {
        try {

            String searchStrt =  Arrays.stream(searchStr).map(str -> "#"+str+" ").collect(Collectors.joining());
            log.info("Search parameter :{}", searchStrt);

            SearchResults results = twitter.searchOperations().search(

                    new SearchParameters(searchStrt)
//                        .geoCode(new GeoCode(13.0801721, 80.2838331, 100, GeoCode.Unit.MILE))
//                        .lang("en")
                        .resultType(SearchParameters.ResultType.RECENT)
//                        .count(25)
//                        .includeEntities(false))
                    );

            return results.getTweets();

        } catch (RuntimeException ex) {
            log.error("Unable to searchTweet :{}, error: {}", searchStr ,  ex);
        }
        return null;
    }

    public List<String> searchTweetText(Twitter twitter, String... searchStr) {

        List<Tweet> tweets = searchTweet(twitter, searchStr);
        return tweets.stream().map(tweet -> tweet.getText()).collect(Collectors.toList());

    }

    public List<Tweet> searchTweet(String... searchStr) {
        Twitter twitterTemplate = twitterCreator.getTwitterTemplate("SpringAtSO");

        return searchTweet(twitterTemplate, searchStr);
    }

    public List<String> searchTweetText(String... searchStr) {
        Twitter twitterTemplate = twitterCreator.getTwitterTemplate("SpringAtSO");

        return searchTweetText(twitterTemplate, searchStr);
    }
}