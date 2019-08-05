package com.dragonfly.whatshouldi.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "user")
public @Data class User {

	@DynamoDBHashKey(attributeName = "user_name")
	private String userName;

	@DynamoDBAttribute(attributeName = "email_address")
	private String emailAddress;
	
	@DynamoDBAttribute(attributeName = "age")
	private String age;
	
	@DynamoDBAttribute(attributeName = "sex")
	private String sex;
	
	@DynamoDBAttribute(attributeName = "location")
	private String location;
	
	@DynamoDBAttribute(attributeName = "social_id")
	private String socialId;

}
