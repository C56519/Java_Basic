package com.ethanc.set;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/*
 * Set系列集合特点：无序、不重复、无索引
 *
 * - HashSet：无序、不重复、无索引
 * - LinkedHashSet：有序、不重复、无索引
 * - TreeSet：排序、不重复、无索引
 *
 * 注意1：无序指添加数据的顺序和获取出的数据顺序不一致
 * 注意2：Set要用到的常用方法，基本上就是Collection提供的，自己几乎没有额外新增一些常用功能
 */
public class Set1 {
    public static void main(String[] args) {
        // Set集合示例

        // 1、创建一个Set集合，特点：无序，不重复，无索引。
        // Set<String> set = new HashSet<>(); // 一行经典代码 HashSet 无序，不重复，无索引。
        Set<String> set = new LinkedHashSet<>(); // LinkedHashSet 有序，不重复，无索引。
        set.add("鸿蒙");
        set.add("鸿蒙");
        set.add("java");
        set.add("java");
        set.add("电商设计");
        set.add("电商设计");
        set.add("新媒体");
        set.add("大数据");
        System.out.println(set);

        // 2、创建一个TreeSet集合：排序（默认一定要大小升序排序），不重复，无索引。
        Set<Double> set1 = new TreeSet<>();
        set1.add(3.14);
        set1.add(5.6);
        set1.add(1.0);
        set1.add(1.0);
        set1.add(2.0);
        System.out.println(set1);
    }
}
