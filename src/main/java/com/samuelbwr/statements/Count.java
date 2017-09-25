package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityAccessor;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableMap;


public class Count {

    private static final Map<String, Function<List, Statement>> map = unmodifiableMap( Stream.of(
            new AbstractMap.SimpleImmutableEntry<String, Function<List, Statement>>( "*", All::new ),
            new AbstractMap.SimpleImmutableEntry<String, Function<List, Statement>>( "distinct", Distinct::new ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    public static Statement getInstance(List<String> command) {
        return map.get( command.get( 0 ) ).apply( command.subList( 1, command.size() ) );
    }

    public static class All implements Statement<Integer> {
        private Integer count;

        public All() {}
        private All(List<String> command) {}

        @Override
        public void run(List<City> cities) {
            count = cities.size();
        }

        @Override
        public void printResult() {
            System.out.println( "The number of records are " + count );
        }

        @Override
        public Integer getRawResult() {
            return count;
        }
    }

    public static class Distinct implements Statement<Long> {
        String property;
        Long count;

        public Distinct(String property) {
            this.property = property;
        }

        private Distinct(List<String> command) {
            this( command.get( 0 ) );
        }

        @Override
        public void run(List<City> cities) {
            count = cities.stream()
                    .map( (city -> CityAccessor.namedGetters.get( property ).apply( city )) )
                    .distinct()
                    .count();
        }

        @Override
        public void printResult() {
            System.out.println( "The number of distinct elements is for the property " + property + " is " + count );
        }

        @Override
        public Long getRawResult() {
            return count;
        }
    }
}
