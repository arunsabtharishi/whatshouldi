package com.dragonfly.whatshouldi.dynamodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;
import com.dragonfly.whatshouldi.dynamodb.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserInfoRepository {

    @Autowired
    @Qualifier("dynamoDBMapper")
    private DynamoDBMapper adhCatalogDynamoDBMapper;

    public Optional<User> read(String userName) {
        return Optional.ofNullable(adhCatalogDynamoDBMapper.load(User.class, userName));
    }

    public List<User> list() {
        log.info("Entering readAll()");
        PaginatedList<User> results = adhCatalogDynamoDBMapper.scan(User.class,
                new DynamoDBScanExpression());
        results.loadAllResults();
        return results;
    }


}
