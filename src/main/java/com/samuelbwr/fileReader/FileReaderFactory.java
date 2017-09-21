package com.samuelbwr.fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderFactory {

    public static FileReader getInstance(Path path) {
        String fileType = getFileType( path );
        if (fileType.equals( "csv" ))
            return new CsvReader();
        throw new RuntimeException( "No format found" );
    }

    private static String getFileType(Path path) {
        try {
            return Files.probeContentType( path );
        } catch (IOException ioException) {
            throw new RuntimeException(
                    "ERROR: Unable to determine file type for " + path.getFileName()
                            + " due to exception " + ioException );
        }

    }
}
