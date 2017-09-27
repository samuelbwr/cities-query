package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityAccessor;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class CountDistinct implements Statement {

    private Function property;

    public CountDistinct(String property) {
        this.property = Optional.ofNullable( CityAccessor.namedGetters.get( property ) )
                .orElseThrow( PropertyNotFoundException::new );
    }

    @Override
    public Result run(List<City> cities) {
        long startTime = System.currentTimeMillis();
        long value = cities.stream()
                .map( (city -> property.apply( city )) )
                .distinct()
                .count();
        long endTime = System.currentTimeMillis();
        return new Result( value, endTime - startTime );
    }

}
