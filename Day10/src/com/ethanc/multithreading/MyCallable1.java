package com.ethanc.multithreading;

import java.util.concurrent.Callable;

public class MyCallable1 implements Callable<String> {
    private int n;

    public MyCallable1(int n) {this.n = n;}
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程计算1-" + n + "的和是：" + sum;
    }
}
