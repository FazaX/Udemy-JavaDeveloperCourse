package com.fazax.udemy;

import static com.fazax.udemy.ThreadColor.ANSI_GREEN;

/**
 * Created by fazax on 08.10.2016.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_GREEN + "Hello from MyRunnable thread.");
    }
}
