package com.fazax.udemy;

public class Challenge1 {

    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String myString = "Let's split this up into an array";
//                String[] parts = myString.split(" ");
//                for(String part: parts){
//                    System.out.println(part);
//                }
//            }
//        };

        Runnable runnable = ()-> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part: parts){
                System.out.println(part);
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();
    }
}
