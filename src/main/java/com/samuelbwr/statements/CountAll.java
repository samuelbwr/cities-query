package com.samuelbwr.statements;

import com.samuelbwr.cities.City;

import java.util.List;

public class CountAll implements Statement {

    @Override
    public Result run(List<City> cities) {
        long startTime = System.currentTimeMillis();
        long value = cities.size();
        long endTime = System.currentTimeMillis();
        return new Result( value, endTime-startTime);
    }
}
