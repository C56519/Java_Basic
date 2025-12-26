package com.ethanc.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;

/*
 * Stream流：
 * 1 介绍：是jdk8开始新增的一套API (java.util.stream.*)，可以用于操作集合或者数组的数据。
 *       Stream流大量的结合了Lambda的语法风格来编程，功能强大，性能高效，代码简洁，可读性好。
 *
 * 2 Stream流整体流程：
 *  数据源 -> 获取 Stream 流 -> 中间操作-> 终结操作 -> 获取结果
 *  1) 获取流：先基于数组、集合、Stream.of、数值流等，创建Stream流对象
 *  2) 中间操作：调用Stream流的方法进行数据处理，filter、map、flatMap、distinct、sorted、limit、skip ...
 *  3) 终结操作：forEach、collect、count、reduce ...
 *     ==> 终结操作才真正触发“遍历 + 计算”，生成结果或产生副作用。
 *  4) 获取结果：终结操作返回结果
 */
public class Stream1 {
    public static void main(String[] args) {
        // 一、获取流

        // 1) 集合：使用 集合.stream() 方法，获取当前集合的 Stream 流

        // 获取List集合的Stream流
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        Stream<Integer> s1 = list1.stream();

        // 获取Map集合的Stream流
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        // 获取键流
        Stream<String> sk = map.keySet().stream();   // 通过.keySet()获取键的Set集合，再对Set集合调用.stream()方法
        // 获取值流
        Stream<Integer> sv = map.values().stream();   // 通过.values()获取值的Collection集合，在对Collection集合调用.stream()方法
        // 获取键值对流
        Stream<Map.Entry<String, Integer>> skv = map.entrySet().stream();


        // 2) 数组：不像集合能直接 .stream()，因为数组不是 Collection，没有 .stream() 方法
        String[] arr = {"a", "b", "c"};
        // a. 使用 Arrays.stream(arr) 方法
        Stream<String> s2 = Arrays.stream(arr);      // 推荐

        // b. 使用 Stream.of() 方法
        Stream<String> s3 = Stream.of(arr);         // 也可以


        // 3) 讲解 Stream.of() 静态工厂方法
        // Stream.of() 方法可接任意数量、类型的参数，比如当想迅速通过一些临时数据创建Stream流时，可以这样用
        Stream<String> s4 = Stream.of("a", "b", "c");
        // 可传入输入，例子见上面的用数组创建Stream流的b方法


        // 4) 数值流：避免装箱开销 + 自带数值工具方法
        // 专门针对数值进行操作的流
        // 分类：IntStream、LongStream、DoubleStream
        // .sum() .average() .max()等工具方法
        int sum = IntStream.of(1, 2, 3, 4).sum();    // 直接求和

        // 对于数组
        int[] arr1 = {1, 2, 3, 4};
        // 可直接使用IntStream.of()创建数值流
        int sum1 = IntStream.of(arr1).sum();
        // 也可以先用Arrays.stream()创建数组的Stream流，再用一个IntStream类型接收，就可以用数值流方法了
        IntStream is = Arrays.stream(arr1);
        int sum2 = is.sum();
    }

}
