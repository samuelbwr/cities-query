package com.samuelbwr.cities;

import com.samuelbwr.mapper.Mapper;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityMapper implements Mapper<City> {

    static final Map<Integer, BiConsumer> map = Collections.unmodifiableMap( Stream.of(
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 0, City::setIbge_id ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 1, City::setUf ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 2, City::setName ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 3, City::setCapital ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 4, City::setLon ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 5, City::setLat ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 6, City::setNo_accents ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 7, City::setAlternative_names ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 8, City::setMicroregion ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 9, City::setMesoregion ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    @Override
    public City fromOrderedList(String[] list) {
        City city = new City();
        for (int i = 0; i < list.length; i++)
            map.get( i ).accept( city, list[ 0 ] );
        return city;
    }

    @Override
    public List<City> bulkFromStringStream(Stream<String[]> stream) {
        return stream
                .map( splitted -> fromOrderedList( splitted ) )
                .collect( Collectors.toList() );
    }
}