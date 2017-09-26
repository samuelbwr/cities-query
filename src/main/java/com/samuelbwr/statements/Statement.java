package com.samuelbwr.statements;

import com.samuelbwr.cities.City;
import com.samuelbwr.print.Printable;

import java.util.List;

public interface Statement<T> extends Printable{
    void run(List<City> cities);

    T getRawResult();
}
