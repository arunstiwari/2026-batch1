package com.fil.threads;

import java.util.concurrent.*;

public class ThreadApp {

    private static void log(Object message){
        System.out.println(Thread.currentThread().getName()+"  : "+message);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread.currentThread().setName("Main-Thread");
        // First way to create thread
        Runnable r = ()-> {
            for (int i = 0; i < 100; i++) {
                log(i);
            }
        };
        Thread t = new Thread(r,"Worker-Thread");
        t.start();

        log("Main") ;


        //Second way
        Thread t1 = new Thread(()->{
            for (int i = 100; i < 150; i++) {
               log(i);
            }
        },"Child-Thread");

        t1.start();

        // 3rd way:
        Thread.Builder builder = Thread.ofPlatform().name("Builder-Thread",1);
       Thread w1=  builder.start(t1);
       Thread w2 =  builder.start(t1);

       //4th Way:
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Double> future = executorService.submit(()->square(5));
        log("Future: "+future.isDone());
        log("Future: "+future.get()); // BLOCK
        log("Future: "+future.state());
//        executorService.shutdown();



    }

    private static double square(double n) throws InterruptedException {
        Thread.sleep(1000);
        return n * n;
    }
}
