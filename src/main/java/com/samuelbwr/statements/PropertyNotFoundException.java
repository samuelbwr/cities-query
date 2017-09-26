package com.samuelbwr.statements;

public class PropertyNotFoundException extends RuntimeException{

    private static final String MESSAGE = "This property doesn't exist";

    public PropertyNotFoundException() {
        super( MESSAGE );
    }
}
