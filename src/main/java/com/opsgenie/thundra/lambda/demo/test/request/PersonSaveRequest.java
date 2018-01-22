package com.opsgenie.thundra.lambda.demo.test.request;

/**
 * @author Fazilet Ozer
 * @version 19/01/2018 16:06.
 */
public class PersonSaveRequest {

    public static String PERSON_ID = "id";
    public static String PERSON_FIRSTNAME = "firstName";
    public static String PERSON_LASTNAME = "lastName";

    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public PersonSaveRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonSaveRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonSaveRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
