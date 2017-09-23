package com.samuelbwr.file;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface FileReader {

    List<String[]> from(Path filePath);
}
