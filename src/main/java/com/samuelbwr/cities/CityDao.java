package com.samuelbwr.cities;

import com.samuelbwr.file.FileReaderFactory;
import com.samuelbwr.mapper.Mapper;
import com.samuelbwr.statements.Statement;

import java.util.List;

public class CityDao {

    private static List<City> CITIES;

    public CityDao(String fileLocation) {
        Mapper mapper = new CityMapper();
        CITIES = mapper.bulkFromOrderedList( FileReaderFactory.getInstance( fileLocation ).toListWithOrderedAttributes() );
    }

    public void runStatement(Statement statement) {
        statement.run( CITIES );
    }
}
