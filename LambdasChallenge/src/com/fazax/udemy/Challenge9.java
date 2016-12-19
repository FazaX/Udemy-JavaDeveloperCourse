package com.fazax.udemy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fazax on 25.10.2016.
 */
public class Challenge9 {
    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "ava",
                "Olivia",
                "emily",
                "Isla",
                "Oliver",
                "harry",
                "Jacob"
        );

        topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println("Number of names starting with A: " +
                topNames2015
                        .stream()
                        .filter(s -> s.startsWith("a") || s.startsWith("A"))
                        .count()
        );
    }
}
