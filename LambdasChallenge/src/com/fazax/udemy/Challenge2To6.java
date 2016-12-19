package com.fazax.udemy;

import java.util.function.Function;

/**
 * Created by fazax on 25.10.2016.
 */
public class Challenge2To6 {
    public static void main(String[] args) {

        String myString = "Let's split this up into an array";
        System.out.println(everySecondLetter(myString));

        Function<String, String> lambdaString = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i=0; i < s.length(); i++){
                if(i%2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(lambdaString.apply(myString));
        System.out.println(lambdaString.apply("1234567890"));

        System.out.println(everySecondCharacter(lambdaString,"1234567890"));
    }

    public static String everySecondLetter(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i=0; i < source.length(); i++){
            if(i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String,String> func, String source){
        return func.apply(source);

    }

}
