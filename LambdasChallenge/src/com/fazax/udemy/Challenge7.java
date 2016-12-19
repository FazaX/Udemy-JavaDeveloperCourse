package com.fazax.udemy;

import java.util.function.Supplier;

/**
 * Created by fazax on 25.10.2016.
 */
public class Challenge7 {

    public static void main(String[] args) {

        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();

        System.out.println(supplierResult);
    }
}
