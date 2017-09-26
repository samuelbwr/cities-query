package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FilterTest {

    @Test
    public void ensureCanInstantiateFilterByPropertyStatement() {
        Statement statement = Filter.getInstance( Arrays.asList( "uf", "value" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Filter.ByProperty.class ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateInvalidCountCommand() {
        Filter.getInstance( Arrays.asList( "other", "value" ) );
    }

    @Test
    public void ensureCountAllCanFilterBYProperty() {
        Filter.ByProperty filterByProperty = new Filter.ByProperty( "uf", "RS" );
        filterByProperty.run( Arrays.asList( createCity( "SC" ), createCity( "SC" ), createCity( "RS" ) ) );
        Assert.assertThat( filterByProperty.getRawResult().size(), CoreMatchers.equalTo( 1 ) );
    }

    private City createCity(String uf) {
        City city = new City();
        city.setUf( uf );
        return city;
    }
}
