package com.fazax.udemy;

import static com.fazax.udemy.ThreadColor.ANSI_BLUE;

/**
 * Created by fazax on 08.10.2016.
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println( ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}

