package com.fil.threads;

import java.util.concurrent.RecursiveTask;

public class SummationTask extends RecursiveTask<Long> {
    int[] data ;
    int start, end;

    public SummationTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length<=10){
            long sum =0;
            for (int i=start;i<end;i++){
                sum +=data[i];
            }
            return sum;
        }
        int mid = start + length/2;
//        System.out.println("length: "+length);
        SummationTask left = new SummationTask(data,start, mid);
        SummationTask right = new SummationTask(data,mid, end);

        left.fork();
        right.fork();
        long result2 = left.join();
        long result1 = right.join();
        return result2 + result1;
    }
}
