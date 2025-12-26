package com.ethanc.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

// 遍历 Collection集合
// 1. 使用迭代器遍历
//      a. 创造要遍历集合的迭代器对象 it
//      b. 遍历   it.hasNext() 判断是否还有下一个元素，返回Boolean  it.next()
//                it.next() 返回接下来将要遍历的元素
//                it.remove() 删除当前正在遍历的元素
// 2. 使用for each遍历
// 格式：for (元素的数据类型 变量名 : 数组或集合名) {...}
// 本质是迭代器遍历的简写，也就是用了迭代器，但是做了封装，迭代器对象没有暴露

// 3. Collection集合的.forEach()方法结合Lambda表达式来遍历集合
// 格式：collection.forEach(Lambda表达式)

// 三种遍历方式的区别:
/*
 * 解决并发修改异常问题的方案
 *
 * ① 如果集合支持索引，可以使用for循环遍历，每删除数据后做i--；或者可以倒着遍历
 * ② 可以使用迭代器遍历，并用迭代器提供的删除方法删除数据。
 *
 * 注意：增强for循环/Lambda遍历均不能解决并发修改异常问题，
 *       因为它们只适合做数据的遍历，不适合同时做增删操作。
 */

public class Collection3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(13);
        arrlist.add(22);
        arrlist.add(38);
        arrlist.add(43);
        System.out.println(arrlist);

        // 1. 使用迭代器对象遍历
        // 1.1 生成arrlist的迭代器对象
        Iterator<Integer> it = arrlist.iterator();
        // 1.2 遍历
        while (it.hasNext()) {
            Integer i = it.next();  // 如果越界会抛出NoSuchElementException异常
            System.out.println(i);
        }

        // 2. for each遍历
        for (Integer i : arrlist) {
            System.out.println(i);
        }
        // 也可以遍历数组
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }

        // 3. Collection集合的.forEach()方法结合Lambda表达式来遍历集合
        // 3.1 先了解 .forEach()方法
        // .forEach()源码中参数是接收一个用泛型规定上界的Consumer接口，此接口是一个Java内部函数式接口，内部有个抽象方法accept()
        // .forEach()源码中的遍历逻辑内，会调用Consumer接口的accept()方法，也就是在这个方法里要写每次循环要执行的逻辑（解耦思想）
        // 所以我们用了匿名内部类直接将Consumer接口的实现类当foreach函数的参数传入
        arrlist.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer a) {
                System.out.println(a);
            }
        });

        // 使用Lambda表达式简化
        // 因为 Consumer接口@FunctionalInterface是个函数式接口
        arrlist.forEach(a -> System.out.println(a));
        // 继续简化（了解下就行）
        arrlist.forEach(System.out::println);
    }
}
