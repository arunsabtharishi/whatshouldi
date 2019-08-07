package com.dragonfly.whatshouldi.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;
import com.dragonfly.whatshouldi.requests.ResultRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService{
    @Value("${aws.service.accessKey}")
    private String awsAccessKey;
    @Value("${aws.service.secretKey}")
    private String awsSecretKey;

    @Override
    public ResultRequest getResults(String userName, String searchKey) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .withRegion("us-east-1").build();

        List<AttributeValue> results = results(userName, searchKey, client);
        List<String> resultList = new ArrayList<>();
        for(AttributeValue resultAttributeValue : results) {
            resultList.add(resultAttributeValue.getS());
        }

        ResultRequest resultRequest = new ResultRequest();
        resultRequest.setResults(resultList);
        resultRequest.setTags(tags(results, client));
        return resultRequest;
    }

    private List<AttributeValue> results(String userName, String searchKey,  AmazonDynamoDB client) {
        HashMap<String,AttributeValue> key_to_get =
                new HashMap<String,AttributeValue>();

        key_to_get.put("user_name", new AttributeValue(userName));
        key_to_get.put("search_key", new AttributeValue(searchKey));

        GetItemRequest request = null;
        request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName("results")
                .withProjectionExpression("results");
        GetItemResult result = client.getItem(request);
        List<AttributeValue> results = result.getItem().get("results").getL();
        List<String> resultList = new ArrayList<>();
        for(AttributeValue resultAttributeValue : results) {
            resultList.add(resultAttributeValue.getS());
        }
        return results;
    }

    private List<String> tags(List<AttributeValue> resultList, AmazonDynamoDB client) {
        HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
        Condition condition = new Condition()
                .withComparisonOperator(ComparisonOperator.IN.toString())
                .withAttributeValueList(resultList);
        scanFilter.put("result_key", condition);
        Set<String> tags = new HashSet<>();
        ScanRequest scanRequest = new ScanRequest("tags").withScanFilter(scanFilter);
        ScanResult scanResult = client.scan(scanRequest);
        scanResult.getItems().forEach(item->{
            tags.addAll(item.get("tags").getL().stream().map(tag-> {
                return tag.getS();
            }).collect(Collectors.toSet()));
        });
        return tags.stream().filter(tag->tag!=null).collect(Collectors.toList());
    }
}
