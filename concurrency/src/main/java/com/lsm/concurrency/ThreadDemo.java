package com.lsm.concurrency;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.suspend();
        t.resume();

        Thread.yield();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}
