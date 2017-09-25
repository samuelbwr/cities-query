package com.samuelbwr.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderFactory {

    public static FileReader getInstance(String filePath) {
        ClassLoader classLoader = FileReaderFactory.class.getClassLoader();
        Path path = Paths.get( classLoader.getResource( filePath ).getFile() );
        String fileType = getFileType( path );
        if (fileType.equals( "text/csv" ))
            return new CsvReader( path, "," );
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
