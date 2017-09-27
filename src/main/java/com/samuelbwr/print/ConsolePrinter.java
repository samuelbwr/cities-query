package com.samuelbwr.print;

import java.util.Set;

public class ConsolePrinter {
    public static void print(Object obj, long timeSpent){
        if(obj instanceof Set)
            ((Set) obj).stream().forEach( System.out::println );
        else
            System.out.println( obj );

        System.out.println("In "+timeSpent+" ms\n");

    }
}
