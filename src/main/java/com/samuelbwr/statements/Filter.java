package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityAccessor;
import com.samuelbwr.print.Printable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Filter {

    public static Statement getInstance(List<String> command) {
        return new ByProperty( command.get( 0 ), command.get( 1 ) );
    }

    public static class ByProperty implements Statement<Set> {
        String property;
        String value;
        Set<City> filteredCities;

        public ByProperty(String property, String value) {
            this.property = property;
            this.value = value;
        }

        @Override
        public void run(List<City> cities) {
            filteredCities = cities.stream()
                    .filter( city -> CityAccessor.namedGetters.get( property ).apply( city ).equals( value ) )
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
