package com.samuelbwr.cities;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CityMapperTest {

    @Test
    public void ensureCanMapFromOrderedList() {
        String[] list = new String[]{ "1","SC","Teste","","-1.2","-2.11","Teste","","Teste","Teste" };
        CityMapper cityMapper = new CityMapper();
        City city = cityMapper.fromOrderedList( list );
        assertEquals( city.getIbge_id(), list[ 0 ] );
    }

    @Test
    public void ensureCanBulkMap() {
        List<String[]> list = Arrays.asList(
                new String[]{ "1","SC","Teste","","-1.2","-2.11","Teste","","Teste","Teste" },
                new String[]{ "1","SC","Outro Teste","","-4.3","-3.21","Outro teste","","Outro teste","Outro teste" }
        );
        CityMapper cityMapper = new CityMapper();
        List<City> cities = cityMapper.bulkFromOrderedList( list );
        assertEquals( cities.size(), 2 );
    }
}
