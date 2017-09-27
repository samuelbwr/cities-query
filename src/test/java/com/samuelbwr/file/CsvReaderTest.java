package com.samuelbwr.file;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvReaderTest {

    @Test
    public void ensureCanReadResourcesCsv() {
        FileReader reader = new CsvReader( getFilePath("short-cidades.csv"), "," );
        List<String[]> list = reader.toListWithOrderedAttributes(true);
        Assert.assertThat( list.size(), CoreMatchers.equalTo( 4 ) );
    }

    private InputStream getFilePath(String filePath) {
        ClassLoader classLoader = CsvReaderTest.class.getClassLoader();
        return  classLoader.getResourceAsStream( filePath );
    }

}
