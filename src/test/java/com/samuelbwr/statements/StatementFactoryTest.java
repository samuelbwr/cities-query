package com.samuelbwr.statements;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StatementFactoryTest {
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

    @Test
    public void ensureCanInstantiateFilterByPropertyStatement() {
        Statement statement = StatementFactory.getFilterInstance( Arrays.asList( "uf", "value" ) );
        Assert.assertThat( statement, CoreMatchers.instanceOf( FilterByProperty.class ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateInvalidFilterCommand() {
        StatementFactory.getFilterInstance( Arrays.asList( "other", "value" ) );
    }

    @Test(expected = StatementNotImplementedException.class)
    public void ensureCantInstantiateInvalidCountCommand(){
        StatementFactory.getCountInstance( Arrays.asList( "aggregated" ) );
    }

    @Test(expected = PropertyNotFoundException.class)
    public void ensureCantInstantiateDistinctCountWithInvalidProperty(){
        StatementFactory.getCountInstance( Arrays.asList( "distinct", "other" ) );
    }
}
