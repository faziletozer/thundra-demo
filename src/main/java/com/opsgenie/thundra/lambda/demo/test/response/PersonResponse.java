package com.opsgenie.thundra.lambda.demo.test.response;

import java.util.Map;

/**
 * @author Fazilet Ozer
 * @version 18/01/2018 10:00.
 */
public class PersonResponse {

    private String message;
    private Map item;

    public String getMessage() {
        return message;
    }

    public PersonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map getItem() {
        return item;
    }

    public PersonResponse setItem(Map item) {
        this.item = item;
        return this;
    }
}
