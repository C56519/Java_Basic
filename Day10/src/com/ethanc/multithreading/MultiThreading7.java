package com.ethanc.multithreading;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/*
 * 1. Executors是一个线程池的工具类，提供了很多静态方法用于返回不同特点的线程池对象。
 *
 * | 方法名称                                                  | 说明                                                                 |
 * |-----------------------------------------------------------|----------------------------------------------------------------------|
 * | public static ExecutorService newFixedThreadPool(int nThreads) | 创建固定线程数量的线程池，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它。 |
 * | public static ExecutorService newSingleThreadExecutor()        | 创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程。      |
 * | public static ExecutorService newCachedThreadPool()            | 线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了6s则会被回收掉。              |
 * | public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) | 创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务。                 |
 *
 * 2. 特别注意：大型并发系统环境中使用Executors如果不注意可能会出现系统风险。
 * 阿里巴巴Java开发手册
 *【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，
 *    这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors 返回的线程池对象的弊端如下：
 * 1）FixedThreadPool 和 SingleThreadPool:
 *    允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2）CachedThreadPool 和 ScheduledThreadPool:
 *    允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
 *
 * 3. 最大线程数设置的合理范围：
 * CPU 密集型任务：上限通常按照CPU的逻辑处理器数量来设置
 * IO/阻塞（平台线程）：常见上限 200~500（看业务/内存/连接池），不要无脑上千
 * IO/阻塞（虚拟线程，Java 21+）：线程数不再是主要瓶颈，但要用连接池/信号量限制外部资源并发
 *
 * 4. 并行和并发
 * 并发：进程中的线程是由CPU负责调度执行的，但CPU能同时处理线程的数量有限，为了保证全部线程都能往前执行，
 * CPU会轮询为系统的每个线程服务，由于CPU切换的速度很快，给我们的感觉这些线程在同时执行，这就是并发。
 *
 * 并行：在同一个时刻上，同时有多个线程在被CPU调度执行。
 */

public class MultiThreading7 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<String> f1 = pool.submit(new MyCallable1(100));
        Future<String> f2 = pool.submit(new MyCallable1(200));
        Future<String> f3 = pool.submit(new MyCallable1(300));
        Future<String> f4 = pool.submit(new MyCallable1(400));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
