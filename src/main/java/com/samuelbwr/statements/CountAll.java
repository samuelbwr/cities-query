package com.samuelbwr.statements;

import com.samuelbwr.cities.City;

import java.util.List;

public class CountAll implements Statement {

    public CountAll() {
    }

    @Override
    public Result run(List<City> cities) {
        return new Result( cities.size() );
    }
}
