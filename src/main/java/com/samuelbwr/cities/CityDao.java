package com.samuelbwr.cities;

import com.samuelbwr.file.FileReaderFactory;
import com.samuelbwr.mapper.Mapper;
import com.samuelbwr.statements.Result;
import com.samuelbwr.statements.Statement;

import java.util.List;

public class CityDao {

    private final List<City> cities;

    public CityDao(String fileLocation) {
        Mapper mapper = new CityMapper();
        cities = mapper.mapBulkFromOrderedList( FileReaderFactory.getInstance( fileLocation ).toListWithOrderedAttributes(true) );
    }

    public Result runStatement(Statement statement) {
        return statement.run( cities );
    }
}
