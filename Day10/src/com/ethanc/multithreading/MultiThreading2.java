package com.ethanc.multithreading;


// 创建线程的第二种方法
// 1. 定义一个实现类来实现Runnable接口，成为一个线程任务类
// 2. 重写run()方法
// 3. 创建该实现类的实例，称为一个线程类任务对象
// 4. 使用.Thread()构造器，创建Thread类对象（真正的线程对象），将该任务对象以参数的形式交给真正的线程对象
// 5. 然后.start()启动该现线程

// 方式一和方式二创建线程的优缺点：
// 方式一：
//  - 优点：编码简单
//  - 缺点：存在单继承的局限性，线程类继承Thread后，不能继承其他类，不便于扩展。
// 方式二：
//  - 优点：任务类只是实现接口，可以继续继承其他类、实现其他接口，扩展性强。
//  - 缺点：需要多一个Runnable对象。

// 用匿名内部类简化方式二

class MutiThreading2 {
    public static void main(String[] args) {
        // 3. 创建该任务类对象
        Runnable r = new MyRunnable();
        // 4. 创建Thread类对象，并将任务类对象以参数的形式传给该线程对象
        Thread t = new Thread(r);
        // 5. 启动该线程
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出" + i);
        }

        // 6. 用匿名内部类简化方式二
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类简化");
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();

        // 7. 进一步简化，直接在线程对象参数里new Runnable()，并直接启动
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进一步简化");
            }
        }).start();

        // 8. 更进一步简化，由于源码显示Runnable接口为函数式接口，所以直接用lambda表达式
        new Thread(() -> {
            System.out.println("lambda表达式简化");
        }).start();

    }

}

// 1. 定义一个线程任务类来实现Runnable接口
class MyRunnable implements Runnable{
    // 2. 重写run()方法，内容为线程任务
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程输出" + i);
        }
    }
}
