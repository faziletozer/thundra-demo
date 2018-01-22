package com.opsgenie.thundra.lambda.demo.test.handler;

import com.amazonaws.services.dynamodbv2.document.GetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.opsgenie.thundra.lambda.core.ThundraLambdaRequestHandler;
import com.opsgenie.thundra.lambda.demo.test.client.DynamoDBClient;
import com.opsgenie.thundra.lambda.demo.test.request.PersonGetRequest;
import com.opsgenie.thundra.lambda.demo.test.response.PersonResponse;

import java.util.Map;

/**
 * @author Fazilet Ozer
 * @version 18/01/2018 09:41.
 */
public class GetPersonHandler
        implements ThundraLambdaRequestHandler<PersonGetRequest, PersonResponse> {

    private DynamoDBClient dynamoDBClient;

//    public PersonResponse handleRequest(PersonGetRequest personGetRequest, Context context) {
//        dynamoDBClient = new DynamoDBClient();
//
//        GetItemOutcome getItemOutcome = fetchData(personGetRequest);
//        Map<String, Object> itemAsMap = getItemOutcome.getItem().asMap();
//
//        PersonResponse personResponse = new PersonResponse();
//        personResponse.setMessage("Get successfully!");
//        personResponse.setItem(itemAsMap);
//        return personResponse;
//    }

    private GetItemOutcome fetchData(PersonGetRequest personGetRequest) {

        return dynamoDBClient.getDynamoDBTable()
                .getItemOutcome(
                        new GetItemSpec().withPrimaryKey(PersonGetRequest.PERSON_ID, personGetRequest.getId())
                );
    }

    @Override
    public PersonResponse doHandleRequest(PersonGetRequest personGetRequest, Context context) throws Exception {
        dynamoDBClient = new DynamoDBClient();

        GetItemOutcome getItemOutcome = fetchData(personGetRequest);
        Map<String, Object> itemAsMap = getItemOutcome.getItem().asMap();

        PersonResponse personResponse = new PersonResponse();
        personResponse.setMessage("Get successfully!");
        personResponse.setItem(itemAsMap);
        return personResponse;
    }
}
