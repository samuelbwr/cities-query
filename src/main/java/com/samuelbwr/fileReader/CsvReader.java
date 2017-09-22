package com.samuelbwr.fileReader;

import com.samuelbwr.cities.City;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CsvReader implements FileReader<City> {
    private static final String SEPARATOR = ",";

    @Override
    public Stream<String> streamLines(Path filePath) {
        try (Stream<String> stream = Files.lines( filePath )) {
            return stream;
        } catch (IOException e) {
            throw new RuntimeException( "Unable to read to city" );
        }
    }

    @Override
    public Stream<String[]> streamOrderedAttributes(Path filePath) {
        return streamLines( filePath ).map(line -> line.split( SEPARATOR ));
    }
}
