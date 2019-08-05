package com.dragonfly.whatshouldi.dynamodb.model;

import javax.validation.constraints.NotEmpty;

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
@DynamoDBTable(tableName = "user_account")
public @Data class UserAccount {

	@DynamoDBHashKey(attributeName = "user_name")
	private String userName;

	@NotEmpty
	@DynamoDBAttribute(attributeName = "password")
	private String password;

}
