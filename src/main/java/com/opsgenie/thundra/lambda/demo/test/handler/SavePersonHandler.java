package com.opsgenie.thundra.lambda.demo.test.handler;


import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.opsgenie.thundra.lambda.core.ThundraLambdaRequestHandler;
import com.opsgenie.thundra.lambda.demo.test.client.DynamoDBClient;
import com.opsgenie.thundra.lambda.demo.test.response.PersonResponse;
import com.opsgenie.thundra.lambda.demo.test.request.PersonSaveRequest;

/**
 * @author Fazilet Ozer
 * @version 17/01/2018 16:50.
 */
public class SavePersonHandler
        implements ThundraLambdaRequestHandler<PersonSaveRequest, PersonResponse> {

    private DynamoDBClient dynamoDBClient;

    private PutItemOutcome persistData(PersonSaveRequest personGetRequest) throws ConditionalCheckFailedException {
        return dynamoDBClient.getDynamoDBTable()
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withPrimaryKey(PersonSaveRequest.PERSON_ID, personGetRequest.getId())
                                .withString(PersonSaveRequest.PERSON_FIRSTNAME, personGetRequest.getFirstName())
                                .withString(PersonSaveRequest.PERSON_LASTNAME, personGetRequest.getLastName())));
    }

    @Override
    public PersonResponse doHandleRequest(PersonSaveRequest personSaveRequest, Context context) throws Exception {
        dynamoDBClient = new DynamoDBClient();

        persistData(personSaveRequest);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setMessage("Saved Successfully!!!");
        return personResponse;
    }
}