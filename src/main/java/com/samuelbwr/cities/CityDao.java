package com.samuelbwr.cities;

import com.samuelbwr.Main;
import com.samuelbwr.file.FileReaderFactory;
import com.samuelbwr.mapper.Mapper;
import com.samuelbwr.statements.Statement;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CityDao {

    private static List<City> CITIES;

    public CityDao() {
        ClassLoader classLoader = Main.class.getClassLoader();
        Path path = Paths.get( classLoader.getResource( "cidades.csv" ).getFile() );
        Mapper mapper = new CityMapper();
        CITIES = mapper.bulkFromStringStream( FileReaderFactory.getInstance( path ).from( path ) );
    }

    public void runStatement(Statement statement) {
        statement.run( CITIES );
    }
}
