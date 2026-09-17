package com.fil.threads;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main");
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0; i< 2000; i++){
//                    System.out.println(i);
//                }
//            }
//        };
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i =4000; i< 6000; i++){
                    System.out.println(i);
                }
            }
        };
        Thread t = new Thread(() -> {
            for (int i =0; i< 2000; i++){
                System.out.println(i);
            }
        });
        t.start();

        Thread t1 = new Thread(r1);
        t1.start();
        try {
            t.join();
        }catch (InterruptedException e){

        }



    }
}
