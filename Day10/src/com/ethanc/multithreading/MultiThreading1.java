package com.ethanc.multithreading;

/*
 * 1. 线程和多线程：
 *  - 线程：是程序内部的一条执行流程（Java中用Thread对象来表示）
 *  - 多线程：从软硬件上实现的多条执行流程的技术（多条线程由CPU负责调度执行）
 * 2. 创建线程：
 *  - 方式一：创建一个子类，继承Thread类，覆盖run()方法，然后分配和启动子类的实例
 *
 * 3. 创建线程的注意事项
 *  - 启动线程必须是调用start方法，不是调用run方法。
 *      - 直接调用run方法会当成普通方法执行，并不会告诉CPU创建一个新线程，此时相当于还是单线程执行。
 *      - 只有调用start方法才是启动一个新的线程执行。
 *  - 不要把主线程任务放在启动子线程之前。
 *      - 因为如果放到启动新线程之前，按照代码的从上往下执行，会先在主线程中执行完，然后再启动一个新线程，没什么意义
 */

public class MultiThreading1 {
    // main方法本身就是由一条主线程来执行
    public static void main(String[] args) {
        // 创建线程：

        // 4. 创建线程子类的对象来代表一条线程
        Thread t1 = new MyThread();
        // 5. 启动线程：调用 .start() 方法
        t1.start();

        // 主线程任务
        // 线程与线程之间并行发生，互不干扰，也无法确定谁先谁后，有CPU调度
        System.out.println("线程：" + Thread.currentThread().getName() + "正在执行");
    }
}

// 1. 定义一个子类，继承Thread类
class MyThread extends Thread {
    // 2. 覆盖run()方法
    @Override
    public void run() {
        // 3. 在run()方法中编写线程要执行的任务
        for (int i = 0; i < 10; i++) {
            System.out.println("线程：" + Thread.currentThread().getName() + "正在执行");
        }

    }
}
