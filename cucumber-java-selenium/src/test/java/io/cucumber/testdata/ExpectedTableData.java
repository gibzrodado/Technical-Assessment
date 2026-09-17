package io.cucumber.testdata;

import java.util.List;

public class ExpectedTableData {
    public static final List<List<String>> ROWS = List.of(
            List.of("Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"),
            List.of("Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com"),
            List.of("Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com"),
            List.of("Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com")
    );
}