package com.neuedu.TreadDemo;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            System.out.println(Thread1.currentThread().getName());
        }
    }
}
