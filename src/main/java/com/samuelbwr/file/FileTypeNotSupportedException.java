package com.samuelbwr.file;

public class FileTypeNotSupportedException extends RuntimeException{

    static final String MESSAGE = "File type not supported";

    public FileTypeNotSupportedException() {
        super( MESSAGE );
    }
}
