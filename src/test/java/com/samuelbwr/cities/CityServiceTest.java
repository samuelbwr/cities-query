package com.samuelbwr.cities;

import com.samuelbwr.print.Printable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityServiceTest {

    private CityService cityService;

    @Before
    public void before() {
        cityService = new CityService( "short-cidades.csv" );
    }

    @Test
    public void ensureCanRunStatement() {
        Printable printable = cityService.runCommand( "count *" );
        Assert.assertNotNull( printable );
    }
}
