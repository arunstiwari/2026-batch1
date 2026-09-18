package com.fil.threads;

public class ThreadStates {

    private static void log(Object message){
        System.out.println(Thread.currentThread().getName()+"  : "+message);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Main-Thread");
        Object lock = new Object();

        Thread t = new Thread(()->{
                log(Thread.currentThread().getState());
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                 }
        },"Worker-Thread");

        log(" State after new: "+t.getState());
        t.start();
        log(" State after start: "+t.getState());
        log("State 123 : "+t.getState());

        synchronized (lock){
            lock.notify();
        }
        log("State 456 : "+t.getState());

        Thread.sleep(1000);
        log("State 567 : "+t.getState());
    }
}
