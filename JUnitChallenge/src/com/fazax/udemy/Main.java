package com.fazax.udemy;

public class Main {

    public static void main(String[] args) {

        Utilities utils = new Utilities();

        char[] source = {'h','e','l','l','o'};

        System.out.println(utils.everyNthChar(source, 2));
    }
}
