package com.samuelbwr.mapper;

import java.util.List;
import java.util.stream.Stream;

public interface Mapper<T> {

    T fromOrderedList(String[] list);

    List<T> bulkFromStringStream(Stream<String[]> stream);
}
