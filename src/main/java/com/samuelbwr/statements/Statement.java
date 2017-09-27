package com.samuelbwr.statements;

import com.samuelbwr.cities.City;

import java.util.List;

public interface Statement {
    Result run(List<City> cities);
}
