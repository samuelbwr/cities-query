package com.samuelbwr.interpreters;

import com.samuelbwr.statements.Count;
import com.samuelbwr.statements.Filter;
import com.samuelbwr.statements.Statement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Interpreter<T> {
    Map<String, Function<List, Statement>> statements = Collections.unmodifiableMap( Stream.of(
            new AbstractMap.SimpleEntry<String, Function<List, Statement>>( "count", Count::getInstance ),
            new AbstractMap.SimpleEntry<String, Function<List, Statement>>( "filter", Filter::getInstance ) )
            .collect( Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    Statement interpret(T command);
}
