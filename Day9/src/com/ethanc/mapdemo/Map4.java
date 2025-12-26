package com.ethanc.mapdemo;
import java.util.Set;
import java.util.HashSet;
// Map集合的实现类：HashMap、LinkedHashMap、TreeMap
// 1. HashMap：前面学过HashSet，HashSet集合的底层实现原理就基于HashMap集合，其他一样，只不过 HashSet 仅使用 HashMap 的 key 来存储元素，
//      value 部分通常是一个固定的占位符对象（如 PRESENT），用来凑齐 HashMap 所需要的 key-value 结构，本身没业务含义。
//      且使用static final修饰，只创建一次，每个实例共用这个占位符对象，节省内存，
// 2. LinkedHashMap：前面学过LinkedHashSet的底层实现原理就基于LinkedHashMap集合
// 3. TreeMap：TreeSet 基于TreeMap
public class Map4 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
    }
}
