package com.dragonfly.whatshouldi.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateCreator {
   @Autowired
   private Environment env;

   public Twitter getTwitterTemplate(String accountName) {
      String consumerKey = env.getProperty(accountName + ".consumerKey");
      String consumerSecret = env.getProperty(accountName + ".consumerSecret");
      String accessToken = env.getProperty(accountName + ".accessToken");
      String accessTokenSecret = env.getProperty(accountName + ".accessTokenSecret");
//      Preconditions.checkNotNull(consumerKey);
//      Preconditions.checkNotNull(consumerSecret);
//      Preconditions.checkNotNull(accessToken);
//      Preconditions.checkNotNull(accessTokenSecret);

//      TwitterTemplate twitterTemplate =
//         new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);

      TwitterTemplate twitterTemplate =
              new TwitterTemplate(consumerKey, consumerSecret);
      return twitterTemplate;
   }
}