package com.samuelbwr.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader implements FileReader {
    private static final String SEPARATOR = ",";

    @Override
    public List<String[]> from(Path filePath) {
        try (Stream<String> stream = Files.lines( filePath )) {
            return stream.map( line -> line.split( SEPARATOR ) ).collect( Collectors.toList() );
        } catch (IOException e) {
            throw new RuntimeException( "Unable to read to city" );
        }
    }
}
