package com.opsgenie.thundra.lambda.demo.test.request;


/**
 * @author Fazilet Ozer
 * @version 19/01/2018 16:11.
 */
public class PersonGetRequest {

    public static String PERSON_ID = "id";

    private String id;

    public String getId() {
        return id;
    }

    public PersonGetRequest setId(String id) {
        this.id = id;
        return this;
    }
}
