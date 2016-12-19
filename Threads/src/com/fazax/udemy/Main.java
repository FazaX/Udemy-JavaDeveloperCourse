package com.fazax.udemy;

import static com.fazax.udemy.ThreadColor.ANSI_GREEN;
import static com.fazax.udemy.ThreadColor.ANSI_PURPLE;
import static com.fazax.udemy.ThreadColor.ANSI_RED;

/**
 * Created by fazax on 08.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from main thread.");


        Thread anotherThread = new AnotherThread();
        anotherThread.setName("=== Another Thread ===");
        anotherThread.start();

        new Thread() {
          public void run() {
              System.out.println(ANSI_RED +"Hello from anonymous class thread.");
          }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous MyRunnable");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_GREEN + "Hello after join() with anotherTread.");

                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "Couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();

//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from main thread.");

    }
}
