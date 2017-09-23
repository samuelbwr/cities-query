package com.samuelbwr.cities;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityAccessor {
    static final Map<Integer, BiConsumer> orderedSetters = Collections.unmodifiableMap( Stream.of(
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

    public static final Map<String, Function> namedGetters = Collections.unmodifiableMap( Stream.of(
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "ibge_id", City::getIbge_id ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "uf", City::getUf ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "capital", City::getCapital ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "lon", City::getLon ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "lat", City::getLat ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "no_accents", City::getNo_accents ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "alternative_names", City::getAlternative_names ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "microregion", City::getMicroregion ),
            new AbstractMap.SimpleEntry<String, Function<City, String>>( "mesoregion", City::getMesoregion ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

}
