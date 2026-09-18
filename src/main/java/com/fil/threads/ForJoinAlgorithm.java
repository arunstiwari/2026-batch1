package com.fil.threads;

import java.util.concurrent.ForkJoinPool;

public class ForJoinAlgorithm {

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i^4%100;
        }

        ForkJoinPool pool = ForkJoinPool.commonPool();
        long result = pool.invoke(new SummationTask(numbers,0, numbers.length));
        System.out.println("result: "+result);
    }
}
