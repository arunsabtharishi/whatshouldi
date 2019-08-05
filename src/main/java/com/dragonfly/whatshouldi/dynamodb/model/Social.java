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
@DynamoDBTable(tableName = "social")
public @Data class Social {

	@DynamoDBHashKey(attributeName = "id")
	private String id;

	@DynamoDBAttribute(attributeName = "likes_id")
	private String likesId;
	
	@DynamoDBAttribute(attributeName = "marital_status")
	private String maritalStatus;
	
	@DynamoDBAttribute(attributeName = "checked_in")
	private String checkedIn;

}
