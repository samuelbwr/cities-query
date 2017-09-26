package com.samuelbwr.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderFactory {

    public static FileReader getInstance(String filePath) {
        Path path = getPath( filePath );
        String fileType = getFileType( path );
        if (fileType.equals( "text/csv" ))
            return new CsvReader( path, "," );
        throw new FileTypeNotSupportedException();
    }

    private static Path getPath(String filePath) {
        ClassLoader classLoader = FileReaderFactory.class.getClassLoader();
        try {
            return Paths.get( classLoader.getResource( filePath ).getFile() );
        } catch (NullPointerException e) {
            throw new FileNotFoundException();
        }
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
