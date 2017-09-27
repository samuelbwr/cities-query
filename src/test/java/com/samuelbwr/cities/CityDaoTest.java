package com.samuelbwr.cities;

import com.samuelbwr.statements.CountAll;
import com.samuelbwr.statements.CountDistinct;
import com.samuelbwr.statements.Result;
import com.samuelbwr.statements.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityDaoTest {

    private CityDao dao;

    @Before
    public void before() {
        dao = new CityDao( "short-cidades.csv" );
    }

    @Test
    public void ensureCanRunStatement() {
        Statement statement = new CountAll();
        Result result = dao.runStatement( statement );
        Assert.assertEquals( result.get(), 4l );
    }
}
