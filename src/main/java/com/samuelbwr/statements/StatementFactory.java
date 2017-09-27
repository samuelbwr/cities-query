package com.samuelbwr.statements;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableMap;

public class StatementFactory {

    private static Map<String, Function<List<String>, Statement>> countClasses = unmodifiableMap( Stream.of(
            new AbstractMap.SimpleImmutableEntry<String, Function<List<String>, Statement>>( "*", (list) -> new CountAll() ),
            new AbstractMap.SimpleImmutableEntry<String, Function<List<String>, Statement>>(
                    "distinct", (list) -> new CountDistinct( list.get( 0 ) ) ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    public static Statement getCountInstance(List<String> command) {
        return Optional.ofNullable( countClasses.get( command.get( 0 ) ) )
                .orElseThrow( StatementNotImplementedException::new )
                .apply( command.subList( 1, command.size() ) );
    }

    public static Statement getFilterInstance(List<String> command) {
        return new FilterByProperty( command.get( 0 ), command.get( 1 ) );
    }
}
