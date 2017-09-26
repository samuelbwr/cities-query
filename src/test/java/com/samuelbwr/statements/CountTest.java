package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountTest {

    @Test
    public void ensureCanInstantiateCountAllStatement(){
        Statement statement = Count.getInstance( Arrays.asList( "*" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Count.All.class ) );
    }

    @Test
    public void ensureCanInstantiateCountDistinctStatement(){
        Statement statement = Count.getInstance( Arrays.asList( "distinct", "uf" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Count.Distinct.class ) );
    }

    @Test(expected = StatementNotImplementedException.class)
    public void ensureCantInstantiateInvalidCountCommand(){
        Count.getInstance( Arrays.asList( "aggregated" ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateDistinctCountWithInvalidProperty(){
        Count.getInstance( Arrays.asList( "distinct", "other" ) );
    }

    @Test
    public void ensureCountAllCanCountList(){
        Count.All countAll = new Count.All();
        countAll.run( Arrays.asList( new City() ) );
        Assert.assertThat( countAll.getRawResult(), CoreMatchers.equalTo( 1 ) );
    }

    @Test
    public void ensureCountAllCanCountDistinct(){
        Count.Distinct countDistinct = new Count.Distinct("uf");
        countDistinct.run( Arrays.asList( createCity( "SC" ), createCity( "SC" ), createCity( "RS" ) ) );
        Assert.assertThat( countDistinct.getRawResult(), CoreMatchers.equalTo( 2l ) );
    }

    private City createCity(String uf){
        City city = new City();
        city.setUf( uf );
        return city;
    }
}
