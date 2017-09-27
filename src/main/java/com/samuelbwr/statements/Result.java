package com.samuelbwr.statements;

import com.samuelbwr.print.ConsolePrinter;

public class Result<T> {
    private final T result;
    private final long timeSpent;

    public Result(T result, long timeSpent) {
        this.result = result;
        this.timeSpent = timeSpent;
    }

    public T get() {
        return result;
    }

    public void printToSystemLog() {
        ConsolePrinter.print(result, timeSpent);
    }
}
