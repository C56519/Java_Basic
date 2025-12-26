package com.ethanc.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/*
 * 创建线程的方式三：实现Callable接口 + FutureTask类
 * 一、前两种线程创建方式的问题：
 *  - 前两种创建方式，如果要拿到该线程任务的结果，比较麻烦，因为他们都重写了run()方法，不能直接返回结果
 * 二、步骤
 *  1. 创建一个任务对象：
 *      - 定义一个实现类实现Callable接口
 *      - 重写call()方法，内写线程任务（要做的事 + 要返回的结果）
 *      - 封装Callable类型对象到FutureTask对象：
 *          - 把Callable类型对象以参数形式，传给FutureTask对象的有参构造器（线程任务对象，也可以取线程任务结果，FutureTask本身就是Runnable接口的一个实现类）
 *  2. 把线程任务对象交给Thread对象
 *  3. 调用Thread对象的start方法启动线程
 *  4. 线程执行完毕后，通过FutureTask对象的.get()方法去获取线程任务执行的结果
 *
 * 三、优点和缺点
 * 优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强；
 *       可以在线程执行完毕后去获取线程执行的结果。
 *
 * 缺点：编码复杂一点。
 *
 * 四、三种创建线程方式的优缺点总结：
 *
 * | 方式               | 优点                                      | 缺点                                  |
 * |-------------------|------------------------------------------|--------------------------------------|
 * | 继承Thread类      | 编程比较简单，可以直接使用Thread类中的方法    | 扩展性较差，不能再继承其他的类，不能返回线程执行的结果 |
 * | 实现Runnable接口  | 扩展性强，实现该接口的同时还可以继承其他的类    | 编程相对复杂，不能返回线程执行的结果        |
 * | 实现Callable接口  | 扩展性强，实现该接口的同时还可以继承其他的类，可以得到线程执行的结果 | 编程相对复杂                          |
 */
class MutiThreading3 {
    public static void main(String[] args) {

        // 子线程一
        Callable<String> c1 = new MyCallable(100);
        FutureTask<String> ft1 = new FutureTask<>(c1);
        Thread t1 = new Thread(ft1);
        t1.start();

        // 子线程二
        Callable<String> c2 = new MyCallable(50);
        FutureTask<String> ft2 = new FutureTask<>(c2);
        Thread t2 = new Thread(ft2);
        t2.start();

        // 获取线程任务结果
        // 这里是在主线程中获取，当执行到获取命令时，如果发现该子线程任务未执行完毕，则主线程阻塞，等待该子线程执行完毕，再获取结果
        try {
            System.out.println(ft1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(ft2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
// 看Callable源码，泛型的类型为该任务要返回结果的类型
class MyCallable implements Callable<String> {
    private int n;
    // 通过重写有参构造器，传入任务参数
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
     public String call() throws Exception {
        // 计算1到n的累加和
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程" + Thread.currentThread().getName() + "任务计算的累加合为：" + sum;
    }
}
