package com.ethanc.stream;
import java.util.List;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * Stream流：中间方法
 * 用于对数据进行处理、加工等，
 * 特点：
 * 1. 调用完成后会返回一个“新的 Stream 流”，可以继续链式调用；
 * 2. 惰性求值:不会立刻执行，直到遇到终结操作才真正开始处理数据。
 *
 * 常用中间操作：
 *
 * | 方法签名                                                    | 说明                         |
 * |-----------------------------------------------------------|----------------------------|
 * | Stream<T> filter(Predicate<? super T> predicate)          | 用于对流中的数据进行过滤。          |
 * | Stream<T> sorted()                                        | 对元素进行升序排序              |
 * | Stream<T> sorted(Comparator<? super T> comparator)        | 按照指定规则排序               |
 * | Stream<T> limit(long maxSize)                             | 获取前几个元素                |
 * | Stream<T> skip(long n)                                    | 跳过前几个元素                |
 * | Stream<T> distinct()                                      | 去除流中重复的元素。            |
 * | <R> Stream<R> map(Function<? super T,? extends R> mapper) | 对元素进行加工，并返回对应的新流    |
 * | static <T> Stream<T> concat(Stream a, Stream b)           | 合并a和b两个流为一个流          |
 */
public class Stream2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(5);

        // 1 获取Stream流
        Stream<Integer> s1 = list.stream();
        // 1.1 过滤
        // .filter()
        Stream<Integer> s2 = s1.filter(x -> x > 3);
        // 1.2 终结操作
        s2.forEach(System.out::println);

        // 2 排序
        // .sorted()
        // 直接一行链式调用
        list.stream().sorted().forEach(System.out::println); // 默认升序
        // .sorted()指定规则排序
        list.stream().sorted((x, y) -> Double.compare(y, x)).forEach(System.out::println);  // 降序

        // 3 截取
        // .limit(long maxSize) 获取前几个元素
        // 参数：获取的元素个数
        list.stream().limit(2).forEach(System.out::println);

        // .skip(long n) 跳过前几个元素
        // 参数：跳过的元素个数
        list.stream().skip(2).forEach(System.out::println);

        // 4 去重
        list.stream().distinct().forEach(System.out::println);
        // 如果集合元素是引用类型，那么去重时，需要重写对象的hashCode()和equals()方法

        // 5 映射
        // 加工方法：把流上原来的数据拿出来，转换成新数据
        // .map()
        list.stream().map(s -> s * 2).forEach(System.out::println);

        // 6 合并两个流
        // .concat()
        Stream<Integer> s3 = Stream.of(1, 2, 3);
        Stream<Integer> s4 = Stream.of(4, 5, 6);
        Stream<Integer> s5 = Stream.concat(s3, s4);
        // 当两个流类型不一样是，用Object类型接
        Stream<String> s6 = Stream.of("a", "b", "c");
        Stream<Object> s7 = Stream.concat(s3, s6);

        
    }
}
