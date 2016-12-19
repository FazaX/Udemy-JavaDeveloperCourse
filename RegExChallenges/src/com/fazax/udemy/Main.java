package com.fazax.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<String> challenges = new ArrayList<>();
        challenges.add("I want a bike.");
        challenges.add("I want a ball.");
        challenges.add("Replace all blanks with underscore");

        String regex = "I want a \\w+.";

        Pattern pattern = Pattern.compile(regex);

        challenges.forEach(challenge -> {
            Matcher matcher = pattern.matcher(challenge);

            while (matcher.find()){
                System.out.println(matcher.matches());
            }

            System.out.println(challenge.replaceAll(" ","_"));
        });

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.matches("a+b+c+d+e+f+g+"));
        System.out.println(challenge5.matches("[a-g]+"));

        String challenge7 = "abcd.123";
        System.out.println(challenge7.matches("^\\D+\\.\\d+$"));

        regex = "(\\D+)\\.(\\d+)";
        Pattern pattern8 = Pattern.compile(regex);
        String challenge8 = "abcd.125asdf.3543dafg.466";

        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()){
            System.out.println(matcher8.group(2));
        }

        Pattern pattern9 = Pattern.compile("(\\D+)\\.(\\d+)[\t|\n$]");
        String challenge9 = "abcd.125\tasdf.3543\tdafg.466\n";

        Matcher matcher9 = pattern9.matcher(challenge9);
        while (matcher9.find()){
            System.out.println(matcher9.group(2));
            System.out.println("start(): " + matcher9.start(2));
            System.out.println("end(): " + (matcher9.end(2)-1));
        }

        String challenge11 = "{0,2}, {23, 4}, {x, y}, {4,56}, {25,65}";
        Pattern pattern11 = Pattern.compile("\\{(\\d+),\\s?(\\d+)\\}");
//        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while (matcher11.find()){
            System.out.println("Coordinates: " + matcher11.group(1) + ", " + matcher11.group(2));
//            System.out.println("Coordinates: " + matcher11.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));
        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
    }
}
