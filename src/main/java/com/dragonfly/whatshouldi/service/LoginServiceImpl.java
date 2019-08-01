package com.dragonfly.whatshouldi.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isLoginSuccessFull(String userName, String password) {

        return false;
    }
}
