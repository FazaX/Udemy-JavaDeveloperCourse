package com.fazax.udemy;

import java.util.Random;
import java.util.concurrent.*;

import static com.fazax.udemy.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_CYAN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RED + "I'm being printed for the Callable class");
                return ThreadColor.ANSI_RED + "This is a callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            System.out.println("Something went wrong.");
        } catch (ExecutionException e) {
            System.out.println("Thread was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {

    private String color;
    private ArrayBlockingQueue<String> buffer;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num : nums) {
            try{
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try{
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted.");
        }
    }
}

class MyConsumer implements Runnable {
    private String color;
    private ArrayBlockingQueue<String> buffer;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true){
            synchronized (buffer){
                try{
                    if(buffer.isEmpty()){
                        continue;
                    }
                    if(buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
