package com.samuelbwr.cities;

import com.samuelbwr.statements.Result;
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
        Result result = cityService.runCommand( "count *" );
        Assert.assertNotNull( result.get() );
    }
}
