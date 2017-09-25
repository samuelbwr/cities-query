package com.samuelbwr.file;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvReaderTest {
    @Test
    public void ensureCanReadResourcesCsv() {
        FileReader reader = new CsvReader( getFilePath(), "," );
        List<String[]> list = reader.toListWithOrderedAttributes();
        Assert.assertThat( list.size(), CoreMatchers.equalTo( 5 ) );
    }

    private Path getFilePath() {
        ClassLoader classLoader = CsvReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( "short-cidades.csv" ).getFile() );
    }

}
