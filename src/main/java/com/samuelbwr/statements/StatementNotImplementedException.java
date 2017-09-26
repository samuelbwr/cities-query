package com.samuelbwr.statements;

public class StatementNotImplementedException extends RuntimeException {
    private static final String MESSAGE = "This statement was not implemented";

    public StatementNotImplementedException() {
        super( MESSAGE );
    }
}
