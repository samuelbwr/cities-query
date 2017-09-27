package com.samuelbwr.file;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader implements FileReader {
    private final String separator;
    private final InputStream inputStream;


    public CsvReader(InputStream inputStream, String separator) {
        this.inputStream = inputStream;
        this.separator = separator;
    }

    @Override
    public List<String[]> toListWithOrderedAttributes(boolean skipHeader) {
        BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
        try (Stream<String> stream = reader.lines()) {
            return stream.skip( skipHeader ? 1 : 0 )
                    .map( line -> line.split( separator ) ).collect( Collectors.toList() );
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

}
