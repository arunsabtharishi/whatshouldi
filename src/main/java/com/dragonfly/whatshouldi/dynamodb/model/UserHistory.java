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
@DynamoDBTable(tableName = "user_history")
public @Data class UserHistory {

	@DynamoDBHashKey(attributeName = "user_name")
	private String userName;

	@DynamoDBAttribute(attributeName = "type")
	private String type;
	
	@DynamoDBAttribute(attributeName = "selected")
	private String selected;

}
