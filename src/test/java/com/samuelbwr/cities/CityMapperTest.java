package com.samuelbwr.cities;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CityMapperTest {

    @Test
    public void ensureCanMapFromOrderedList() {
        String[] list = new String[]{ "1", "Test" };
        CityMapper cityMapper = new CityMapper();
        City city = cityMapper.fromOrderedList( list );
        assertEquals( city.getIbge_id(), list[ 0 ] );
    }
}
