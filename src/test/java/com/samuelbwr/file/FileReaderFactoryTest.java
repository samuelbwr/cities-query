package com.samuelbwr.file;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderFactoryTest {

    @Test
    public void ensureCanInstantiateTheCsvFileReader() {
        FileReader fileReader = FileReaderFactory.getInstance( "short-cidades.csv" );
        Assert.assertThat( fileReader, CoreMatchers.instanceOf( CsvReader.class ) );
    }

    @Test(expected = FileTypeNotSupportedException.class)
    public void ensureCantInstantiateNotSupportedFileType() {
        FileReader fileReader = FileReaderFactory.getInstance( "notsupported.txt" );
        Assert.assertThat( fileReader, CoreMatchers.instanceOf( CsvReader.class ) );
    }

    @Test(expected = FileNotFoundException.class)
    public void ensureCantInstantiateInexistentFile() {
        FileReader fileReader = FileReaderFactory.getInstance( "other.otter" );
        Assert.assertThat( fileReader, CoreMatchers.instanceOf( CsvReader.class ) );
    }
}
