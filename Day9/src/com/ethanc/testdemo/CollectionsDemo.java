package com.ethanc.testdemo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections
 * - 是一个用来操作集合的工具类
 *
 * Collections提供的常用静态方法
 *
 * | 方法名称                                                       | 说明                                   |
 * |--------------------------------------------------------------|--------------------------------------|
 * | public static <T> boolean addAll(Collection<? super T> c, T... elements) | 给集合批量添加元素                     |
 * | public static void shuffle(List<?> list)                     | 打乱List集合中的元素顺序               |
 * | public static <T> void sort(List<T> list)                    | 对List集合中的元素进行升序排序         |
 * | public static <T> void sort(List<T> list, Comparator<? super T> c) | 对List集合中元素，按照比较器对象指定的规则进行排序 |
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        // 原来往集合里添加数据，需要一个个add
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(list1);

        // 使用Collections

        // 1. Collections.addAll()
        // 批量添加元素
        // 参数：集合，元素1，元素2，元素3...
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 6, 7, 8, 9, 10);
        System.out.println(list2);

        // 2. Collections.shuffle()
        // 打乱集合中的元素顺序
        // 参数：集合
        Collections.shuffle(list2);
        System.out.println(list2);

        // 3. Collections.sort()
        // 对集合中的元素进行排序
        // 参数：集合，比较器（自定义）Comparator<? super T> c
        Collections.sort(list2);
        System.out.println(list2);
    }
}
