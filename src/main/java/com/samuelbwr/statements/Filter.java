package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityAccessor;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter {

    public static Statement getInstance(List<String> command) {
        return new ByProperty( command.get( 0 ), command.get( 1 ) );
    }

    public static class ByProperty implements Statement<Set> {
        private Function property;
        private String value;
        private Set<City> filteredCities;

        public ByProperty(String property, String value) {
            this.property = Optional.ofNullable( CityAccessor.namedGetters.get( property ) )
                    .orElseThrow( PropertyNotFoundException::new );
            this.value = value;
        }

        @Override
        public void run(List<City> cities) {
            filteredCities = cities.stream()
                    .filter( city -> property.apply( city ).equals( value ) )
                    .collect( Collectors.toSet() );
        }

        @Override
        public void print() {
            System.out.println( "The cities filtered that has the property " + property + " with the value of '" + value + "' are:" );
            filteredCities.forEach( System.out::println );
        }

        @Override
        public Set getRawResult() {
            return filteredCities;
        }
    }
}
