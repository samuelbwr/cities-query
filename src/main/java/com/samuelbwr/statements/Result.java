package com.samuelbwr.statements;

import com.samuelbwr.print.ConsolePrinter;

public class Result<T> {
    final T result;
    final long timeSpent;

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
