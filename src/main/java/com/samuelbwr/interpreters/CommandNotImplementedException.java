package com.samuelbwr.interpreters;

public class CommandNotImplementedException extends RuntimeException {
    private static final String MESSAGE = "This command is not implemented";

    public CommandNotImplementedException() {
        super( MESSAGE );
    }
}
