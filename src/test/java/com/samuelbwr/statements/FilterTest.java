package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

public class FilterTest {

    @Test
    public void ensureCanInstantiateFilterByPropertyStatement() {
        Statement statement = StatementFactory.getFilterInstance( Arrays.asList( "uf", "value" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( FilterByProperty.class ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateInvalidCountCommand() {
        StatementFactory.getFilterInstance( Arrays.asList( "other", "value" ) );
    }

    @Test
    public void ensureCountAllCanFilterBYProperty() {
        FilterByProperty filterByProperty = new FilterByProperty( "uf", "RS" );
        Result<Set> result = filterByProperty.run( Arrays.asList( createCity( "SC" ), createCity( "SC" ), createCity( "RS" ) ) );
        Assert.assertThat( result.get().size(), CoreMatchers.equalTo( 1 ) );
    }

    private City createCity(String uf) {
        City city = new City();
        city.setUf( uf );
        return city;
    }
}
