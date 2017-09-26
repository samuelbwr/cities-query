package com.samuelbwr.file;

public class FileNotFoundException extends RuntimeException{

    private static final String MESSAGE = "The file doesn't exist";

    public FileNotFoundException() {
        super( MESSAGE );
    }
}
