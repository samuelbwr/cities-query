package com.samuelbwr.interpreters;


import com.samuelbwr.statements.Statement;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandInterpreter implements Interpreter<String> {

    @Override
    public Statement interpret(String command) {
        List<String> splitted = Arrays.asList( command.split( " " ) );
        String statement = splitted.get( 0 );
        return Optional.ofNullable( statements.get( statement ) )
                .orElseThrow( CommandNotImplementedException::new )
                .apply( splitted.stream().skip( 1 ).collect( Collectors.toList() ) );
    }
}
