package com.samuelbwr;

import com.samuelbwr.cities.City;
import com.samuelbwr.cities.CityMapper;
import com.samuelbwr.fileReader.FileReader;
import com.samuelbwr.fileReader.FileReaderFactory;
import com.samuelbwr.mapper.Mapper;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        String a = "count *";
        String b = "count distinct %s";
        String c = "filter %s %s";

        Scanner scanner = new Scanner( System.in );

        Path path = Paths.get( Main.class.getResource( "cidades.csv" ).toURI() );
        FileReader reader = FileReaderFactory.getInstance( path );
        Mapper mapper = new CityMapper();
        List<City> cities = mapper.bulkFromStringStream( reader.streamLines( path ) );

        System.out.print( "Enter the file path: " );
        String username = scanner.next();

        System.out.print( "Enter your age: " );
        int age = scanner.nextInt();

        System.out.println( String.format( "%s, your age is %d", username, age ) );

    }


}
