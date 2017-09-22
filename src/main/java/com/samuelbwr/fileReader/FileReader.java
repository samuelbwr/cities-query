package com.samuelbwr.fileReader;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileReader<T> {

    Stream<String> streamLines(Path filePath);

    Stream<String[]> streamOrderedAttributes(Path filePath);
}
