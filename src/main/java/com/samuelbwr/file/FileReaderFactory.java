package com.samuelbwr.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderFactory {

    public static final String TEXT_CSV = "text/csv";

    public static FileReader getInstance(String filePath) {
        InputStream path = getInputStream( filePath );
        String fileType = getFileType( getPath( filePath ) );
        if (fileType.equals( TEXT_CSV ))
            return new CsvReader( path, "," );
        throw new FileTypeNotSupportedException();
    }

    private static InputStream getInputStream(String filePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            return classLoader.getResourceAsStream( filePath );
        } catch (NullPointerException e) {
            throw new FileNotFoundException();
        }
    }


    private static String getFileType(Path filePath) {
        try {
            return Files.probeContentType( filePath );
        } catch (IOException e) {
            throw new RuntimeException(
                    "ERROR: Unable to determine file type for " + filePath
                            + " due to exception " + e );
        }
    }

    private static Path getPath(String filePath) {
        ClassLoader classLoader = FileReaderFactory.class.getClassLoader();
        try {
            return Paths.get( classLoader.getResource( filePath ).getFile() );
        } catch (NullPointerException e) {
            throw new FileNotFoundException();
        }
    }

}
