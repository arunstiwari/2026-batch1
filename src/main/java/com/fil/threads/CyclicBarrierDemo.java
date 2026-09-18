package com.fil.threads;

import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        int parties = 3;

        CyclicBarrier barrier = new CyclicBarrier(parties,
                ()-> System.out.println("Final ODS Loading happens here"));

        ExecutorService executorService = Executors.newFixedThreadPool(parties);
        for (int i = 0; i <parties ; i++) {
            executorService.submit(()->{
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+
                            " is finished: But awaiting for all others to finish work");
                    barrier.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
//        executorService.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.println("All parties are done");
    }
}
