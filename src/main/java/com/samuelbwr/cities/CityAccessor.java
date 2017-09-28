package com.samuelbwr.cities;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityAccessor {
    public static final Map<Integer, BiConsumer> orderedSetters = Collections.unmodifiableMap( Stream.of(
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 0, (city, entry) -> city.setIbgeId( Integer.valueOf( entry ) ) ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 1, City::setUf ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 2, City::setName ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 3, (city, entry) -> city.setCapital( Boolean.valueOf( entry ) ) ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 4, (city, entry) -> city.setLon( Double.valueOf( entry ) ) ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 5, (city, entry) -> city.setLat( Double.valueOf( entry ) ) ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 6, City::setNoAccents ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 7, City::setAlternativeNames ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 8, City::setMicroregion ),
            new AbstractMap.SimpleEntry<Integer, BiConsumer<City, String>>( 9, City::setMesoregion ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    public static final Map<String, Function> namedGetters = Collections.unmodifiableMap( Stream.of(
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "ibge_id", (city) -> city.getIbgeId().toString() ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "uf", City::getUf ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "name", City::getName ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "capital", (city) -> city.getCapital().toString() ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "lon", (city) -> city.getLon().toString() ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "lat", (city) -> city.getLat().toString() ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "no_accents", City::getNoAccents ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "alternative_names", City::getAlternativeNames ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "microregion", City::getMicroregion ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "mesoregion", City::getMesoregion ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

}
