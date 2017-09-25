package com.samuelbwr.cities;

import com.samuelbwr.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class CityMapper implements Mapper<City> {

    @Override
    public City fromOrderedList(String[] list) {
        City city = new City();
        for (int i = 0; i < list.length; i++)
            CityAccessor.orderedSetters.get( i ).accept( city, list[ i ] );
        return city;
    }

    @Override
    public List<City> bulkFromOrderedList(List<String[]> stream) {
        return stream.stream()
                .map( splitted -> fromOrderedList( splitted ) )
                .collect( Collectors.toList() );
    }
}