package com.samuelbwr.fileReader;

import com.samuelbwr.cities.City;

import java.nio.file.Path;
import java.util.List;

public interface FileReader {
    List<City> read(Path filePath);
}
