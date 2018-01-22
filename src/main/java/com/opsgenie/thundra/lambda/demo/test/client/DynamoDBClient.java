package com.opsgenie.thundra.lambda.demo.test.client;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

/**
 * @author Fazilet Ozer
 * @version 18/01/2018 09:47.
 */
public class DynamoDBClient {

    private DynamoDB dynamoDb;
    public String DYNAMODB_TABLE_NAME = "Person";
    private Regions REGION = Regions.US_WEST_2;

    public DynamoDBClient() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(REGION).build();
        dynamoDb = new DynamoDB(client);
    }

    public DynamoDB getDynamoDb() {
        return dynamoDb;
    }

    public Table getDynamoDBTable() {
        return dynamoDb.getTable(DYNAMODB_TABLE_NAME);
    }
}
