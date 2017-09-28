## cities-query ![Codacy Badge](https://api.codacy.com/project/badge/Grade/982ae1b3088742c992cb9c54c616a040)

Improvements delivered after I send the e-mail, but before the deadline: https://github.com/samuelbwr/cities-query/pull/2

Simple project to query for cities there are in a CSV file.

To run:
```
mvn clean install
java -jar target/cities-query-1.0-jar-with-dependencies.jar 
```

To interact with you can use the following commands:
```
count *
count distinct [property]
filter [property] [value]
```

Code developed only with:
 - Java 8
 - Maven
 - JUnit
