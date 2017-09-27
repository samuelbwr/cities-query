package com.samuelbwr.statements;

import com.samuelbwr.print.ConsolePrinter;

public class Result<T> {
    final T result;

    public Result(T result) {
        this.result = result;
    }

    public T get() {
        return result;
    }

    public void printToSystemLog() {
        ConsolePrinter.print(result);
    }
}
