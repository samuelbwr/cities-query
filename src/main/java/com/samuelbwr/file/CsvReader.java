package com.samuelbwr.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader implements FileReader {
    private final String separator;
    private final Path filePath;


    public CsvReader(Path filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    @Override
    public List<String[]> toListWithOrderedAttributes() {
        try (Stream<String> stream = Files.lines( filePath )) {
            return stream.map( line -> line.split( separator ) ).collect( Collectors.toList() );
        } catch (IOException e) {
            throw new RuntimeException( "Unable to read to city" );
        }
    }

}
