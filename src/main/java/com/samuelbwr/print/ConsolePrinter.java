package com.samuelbwr.print;

import java.util.Set;

public class ConsolePrinter {
    public static void print(Object obj){
        if(obj instanceof Set)
            ((Set) obj).stream().forEach( System.out::println );
        else
            System.out.println( obj );

    }
}
