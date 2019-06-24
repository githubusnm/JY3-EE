package com.neuedu.TreadDemo;

public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            System.out.println(Thread1.currentThread().getName());
        }
    }
}
