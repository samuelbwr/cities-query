package com.samuelbwr.interpreters;

public class CommandNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Command not found";

    public CommandNotFoundException() {
        super( MESSAGE );
    }
}
