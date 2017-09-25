package com.samuelbwr.cities;

import com.samuelbwr.statements.Count;
import com.samuelbwr.statements.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityDaoTest {

    CityDao dao;

    @Before
    public void before() {
        dao = new CityDao( "short-cidades.csv" );
    }

    @Test
    public void ensureCanRunStatement() {
        Statement statement = new Count.All();
        dao.runStatement( statement );
        Assert.assertEquals( statement.getRawResult(), 5 );
    }
}
