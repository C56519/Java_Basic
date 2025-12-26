package com.ethanc.multithreading;
import java.util.concurrent.*;
/*
 * 1 线程池：就是一个可以复用线程的技术。
 *
 * 不使用线程池的问题：
 * - 用户每发起一个请求，后台就需要创建一个新线程来处理，下次新任务来了肯定又要创建新线程处理的，创建新线程的开销是很大的，
 * 并且请求过多时，肯定会产生大量的线程出来，这样会严重影响系统的性能。
 *
 * 2 创建线程池
 * - JDK 5.0起提供了代表线程池的接口：ExecutorService。
 * 如何创建线程池对象？
 * - 方式一：使用ExecutorService的实现类ThreadPoolExecutor自创建一个线程池对象。
 * - 方式二：使用Executors（线程池的工具类）调用方法返回不同特点的线程池对象。
 *
 * 3. 方式一：使用ThreadPoolExecutor
 * ThreadPoolExecutor类提供的构造器：
 * public ThreadPoolExecutor(int corePoolSize,
 *                          int maximumPoolSize,
 *                          long keepAliveTime,
 *                          TimeUnit unit,
 *                          BlockingQueue<Runnable> workQueue,
 *                          ThreadFactory threadFactory,
 *                          RejectedExecutionHandler handler)
 *
 * 使用指定的初始化参数创建一个新的线程池对象
 * - 参数一：corePoolSize；指定线程池的核心线程的数量。
 * - 参数二：maximumPoolSize；指定线程池的最大线程数量。
 * - 参数三：keepAliveTime；指定临时线程的存活时间。
 * - 参数四：unit；指定临时线程存活的时间单位(秒、分、时、天)。
 * - 参数五：workQueue；指定线程池的任务队列。
 * - 参数六：threadFactory；指定线程池的线程工厂。
 * - 参数七：handler；指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来了该怎么办）。
 *
 * 比喻理解：
 * - 正式工：corePoolSize（核心线程数）
 * - 最大员工数：maximumPoolSize（最大线程数）
 * - 临时工：maximumPoolSize - corePoolSize（临时线程）
 * - 临时工空闲多久被开除：keepAliveTime（临时线程存活时间）
 *
 * 常用操作
 * - 参数六：threadFactory；指定线程池的线程工厂。
 * - 参数七：handler；指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来了该怎么办）。
 *
 * 5. ExecutorService的常用方法
 * 方法名称：
 * - void execute(Runnable command)
 *   执行 Runnable 任务
 *
 * - Future<T> submit(Callable<T> task)
 *   执行 Callable 任务，返回未来任务对象，用于获取线程返回的结果
 *
 * - void shutdown()
 *   等全部任务执行完毕后，再关闭线程池！
 *
 * - List<Runnable> shutdownNow()
 *   立刻关闭线程池，停止正在执行的任务，并返回队列中未执行的任务
 *
 * 6. 线程池的注意事项
 *
 * 什么时候开始创建临时线程？
 * - 新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。
 *
 * 什么时候会拒绝新任务？
 * - 核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始拒绝任务。
 *
 * 7. 任务拒绝策略
 *
 * | 策略                                      | 说明                                                   |
 * |-------------------------------------------|-------------------------------------------------------|
 * | ThreadPoolExecutor.AbortPolicy()          | 丢弃任务并抛出RejectedExecutionException异常。是默认的策略 |
 * | ThreadPoolExecutor.DiscardPolicy()        | 丢弃任务，但是不抛出异常，这是不推荐的做法               |
 * | ThreadPoolExecutor.DiscardOldestPolicy()  | 抛弃队列中等待最久的任务，然后把当前任务加入队列中        |
 * | ThreadPoolExecutor.CallerRunsPolicy()     | 由主线程负责调用任务的run()方法从而绕过线程池直接执行     |
 */

public class MultiThreading6 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                3, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 上面配置了任务拒绝策略为.AbortPolicy()

        // 使用线程池处理任务
        Runnable target = new MyRunnable1();
        pool.execute(target);   // 提交第一个任务，创建第一个线程，自动启动线程处理这个任务
        pool.execute(target);   // 提交第二个任务，创建第二个线程，自动启动线程处理这个任务
        pool.execute(target);   // 提交第三个任务，创建第三个线程，自动启动线程处理这个任务


        // 关闭线程池，一般关闭
        // pool.shutdown();    // 等所有任务执行完后再关闭线程池
        pool.shutdownNow();     // 直接关闭，不管有没有执行完

    }
}
