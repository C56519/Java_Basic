package com.ethanc.multithreading;

public class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在执行");
        }
    }
}
