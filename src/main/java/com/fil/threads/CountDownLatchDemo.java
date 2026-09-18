package com.fil.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int workers =3;
        CountDownLatch latch = new CountDownLatch(workers);
        ExecutorService executorService = Executors.newFixedThreadPool(workers);
        for (int i =0; i< workers;i++){
            executorService.submit(()-> {
                try {
                    Thread.sleep(500);
                    System.out.println("Thread: "+Thread.currentThread().getName()+ ": i"+ "finished");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        System.out.println("Main Thread: All tasks are done");
        executorService.shutdown();

    }
}
