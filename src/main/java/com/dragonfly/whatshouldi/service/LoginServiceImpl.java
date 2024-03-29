package com.dragonfly.whatshouldi.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

@Service
public class LoginServiceImpl implements LoginService {
    @Value("${aws.service.accessKey}")
    private String awsAccessKey;
    @Value("${aws.service.secretKey}")
    private String awsSecretKey;

    @Override
    public boolean isLoginSuccessFull(String userName, String password) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .withRegion("us-east-1").build();

        GetItemRequest getItemRequest = new GetItemRequest();
        HashMap<String,AttributeValue> key_to_get =
                new HashMap<String,AttributeValue>();

        key_to_get.put("user_name", new AttributeValue(userName));

        GetItemRequest request = null;
        if ("password" != null) {
            request = new GetItemRequest()
                    .withKey(key_to_get)
                    .withTableName("user_account")
                    .withProjectionExpression("password");
        } else {
            request = new GetItemRequest()
                    .withKey(key_to_get)
                    .withTableName("user_account");
        }
        GetItemResult result = client.getItem(request);
        String dbPassword = result.getItem().get("password").getS();
        return password.equals(dbPassword);
    }
}
