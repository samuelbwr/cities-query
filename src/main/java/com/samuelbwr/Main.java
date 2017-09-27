package com.samuelbwr;

import com.samuelbwr.cities.CityService;

import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner( System.in );
        String command;
        CityService service = new CityService( "cidades.csv" );

        do {
            System.out.println( "Enter a command or exit with 'exit'" );
            command = scanner.nextLine();
            if (!"exit".equals( command )) {
                try {
                    service.runCommand( command ).printToSystemLog();
                } catch (RuntimeException e) {
                    System.err.println( e.getMessage() );
                }
            }
        } while (!"exit".equals( command ));
    }


}
