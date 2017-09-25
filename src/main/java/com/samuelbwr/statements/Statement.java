package com.samuelbwr.statements;

import com.samuelbwr.cities.City;

import java.util.List;

public interface Statement<T> {
    void run(List<City> cities);

    void printResult();

    T getRawResult();
}
