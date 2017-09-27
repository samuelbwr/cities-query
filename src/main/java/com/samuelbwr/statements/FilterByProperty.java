package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityAccessor;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterByProperty implements Statement {
    private Function property;
    private String value;

    public FilterByProperty(String property, String value) {
        this.property = Optional.ofNullable( CityAccessor.namedGetters.get( property ) )
                .orElseThrow( PropertyNotFoundException::new );
        this.value = value;
    }

    @Override
    public Result run(List<City> cities) {
        long startTime = System.currentTimeMillis();
        Set list = cities.stream()
                .filter( city -> property.apply( city ).equals( value ) )
                .collect( Collectors.toSet() );
        long endTime = System.currentTimeMillis();
        return new Result( list, endTime - startTime );
    }

}
