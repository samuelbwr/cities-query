package com.samuelbwr.statements;

import com.samuelbwr.cities.City;

import java.util.List;

public interface Statement {
    void run(List<City> cities);

    void printResult();
}
