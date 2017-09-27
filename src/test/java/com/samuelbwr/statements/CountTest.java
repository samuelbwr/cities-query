package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountTest {

    @Test
    public void ensureCanInstantiateCountAllStatement(){
        Statement statement = StatementFactory.getCountInstance( Arrays.asList( "*" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( CountAll.class ) );
    }

    @Test
    public void ensureCanInstantiateCountDistinctStatement(){
        Statement statement = StatementFactory.getCountInstance(Arrays.asList( "distinct", "uf" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( CountDistinct.class ) );
    }

    @Test(expected = StatementNotImplementedException.class)
    public void ensureCantInstantiateInvalidCountCommand(){
        StatementFactory.getCountInstance( Arrays.asList( "aggregated" ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateDistinctCountWithInvalidProperty(){
        StatementFactory.getCountInstance( Arrays.asList( "distinct", "other" ) );
    }

    @Test
    public void ensureCountAllCanCountList(){
        CountAll countAll = new CountAll();
        Result result = countAll.run( Arrays.asList( new City() ) );
        Assert.assertThat( result.get(), CoreMatchers.equalTo( 1 ) );
    }

    @Test
    public void ensureCountAllCanCountDistinct(){
        CountDistinct countDistinct = new CountDistinct("uf");
        Result result = countDistinct.run( Arrays.asList( createCity( "SC" ), createCity( "SC" ), createCity( "RS" ) ) );
        Assert.assertThat( result.get(), CoreMatchers.equalTo( 2l ) );
    }

    private City createCity(String uf){
        City city = new City();
        city.setUf( uf );
        return city;
    }
}
