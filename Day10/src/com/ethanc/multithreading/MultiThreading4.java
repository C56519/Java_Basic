package com.ethanc.multithreading;
/*
 * Thread的常用方法
 *
 * | Thread提供的常用方法                  | 说明                                      |
 * |-------------------------------------|------------------------------------------|
 * | public void run()                   | 线程的任务方法                             |
 * | public void start()                 | 启动线程                                  |
 * | public String getName()             | 获取当前线程的名称，线程名称默认是Thread-索引  |
 * | public void setName(String name)    | 为线程设置名称                            |
 * | public static Thread currentThread()| 获取当前执行的线程对象                     |
 * | public static void sleep(long time) | 让当前执行的线程休眠多少毫秒后，再继续执行     |
 * | public final void join()            | 让调用当前这个方法的线程先执行完！           |
 *
 * Thread提供的常见构造器
 *
 * | 构造器                                      | 说明                                  |
 * |-------------------------------------------|--------------------------------------|
 * | public Thread(String name)                | 可以为当前线程指定名称                 |
 * | public Thread(Runnable target)            | 封装Runnable对象成为线程对象          |
 * | public Thread(Runnable target, String name) | 封装Runnable对象成为线程对象，并指定线程名称 |
 */

public class MultiThreading4 {
    public static void main(String[] args) {
        Thread t1 = new MyThread01();
        // .start() 启动线程
        t1.start();

        // .getName()
        // 获取当前线程的名称
        // 返回值：String
        System.out.println(t1.getName());   // 默认Thread-0

        Thread t2 = new MyThread02();
        // .setName(String name)
        // 参数： String
        // 为当前线程设置名称
        t2.setName("子线程2");     // PS:因为这个.setName是在主线程中执行，所以要在该线程启动前设置名称
        t2.start();
        System.out.println(t2.getName());   // 默认Thread-1

        // Thread.currentThread()
        // 获取当前执行的线程对象。谁调用该代码，就拿到哪个线程对象
        // 返回值：Object
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

    }
}

class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在运行" + i);
        }
    }
}

class MyThread02 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在运行" + i);
        }
    }
}
