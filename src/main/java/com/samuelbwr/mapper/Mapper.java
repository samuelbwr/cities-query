package com.samuelbwr.mapper;

import java.util.List;

public interface Mapper<T> {

    T fromOrderedList(String[] list);

    List<T> mapBulkFromOrderedList(List<String[]> stream);
}
