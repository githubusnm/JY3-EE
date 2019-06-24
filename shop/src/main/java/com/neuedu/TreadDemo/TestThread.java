package com.neuedu.TreadDemo;

public class TestThread {
    public static void main(String[] args) {
//        Thread1 thread1 = new Thread1();
//        Thread1 thread2 = new Thread1();
//        thread1.start();
//        thread2.start();
        Thread2 thread2 = new Thread2();
        Thread thread = new Thread(thread2);
        Thread thread1 = new Thread(thread2);
        thread.start();
        thread1.start();
    }
}
