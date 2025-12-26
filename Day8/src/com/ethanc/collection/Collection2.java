package com.ethanc.collection;
import java.util.Collection;

// Collection集合
// 因为它是所有单列集合的父类，所以先学他的功能，各个子类都通用

import java.util.ArrayList;

/*
 * 1 Collection集合常用方法：
 *
 * | 方法名                        | 说明                               |
 * |-----------------------------|------------------------------------|
 * | public boolean add(E e)     | 把给定的对象添加到当前集合中           |
 * | public void clear()         | 清空集合中所有的元素                 |
 * | public boolean remove(E e)  | 把给定的对象在当前集合中删除           |
 * | public boolean contains(Object obj) | 判断当前集合中是否包含给定的对象    |
 * | public boolean isEmpty()    | 判断当前集合是否为空                 |
 * | public int size()           | 返回集合中元素的个数                |
 * | public Object[] toArray()   | 把集合中的元素，存储到数组中         |
 */
public class Collection2 {
    public static void main(String[] args) {
        // 其实在学ArrayList的时候，已经学过 .add() .remove() .size() .set() .get()
        // 但我打开Collection类，发现没有.set .get

        // 由于 ArrayList继承自Collection，所以这里使用了多态
        Collection<Integer> arList = new ArrayList<Integer>();

        // .add() 添加元素
        arList.add(1);
        arList.add(2);
        arList.add(3);

        // .size() 获取元素个数，返回值是int类型
        int size = arList.size();
        System.out.println(size);

        // .contains() 判断集合中是否包含某个元素，返回值是boolean类型
        boolean b = arList.contains(5);
        System.out.println(b);

        // .remove() 删除元素，返回值是boolean类型
        boolean b1 = arList.remove(1);
        System.out.println(arList);

        // .isEmpty() 判断集合是否为空，返回值是boolean类型
        boolean b2 = arList.isEmpty();
        System.out.println(b2);

        // .toArray() 把集合中的元素，存储到数组中，返回值是Object[]类型
        Object[] arr = arList.toArray();
        System.out.println(arr[0]);
        // 上面转成数组使用的Object[]类型，如果想指定类型
        // 使用实例方法引用
        Integer[] arr1 = arList.toArray(Integer[]::new);

        // .clear() 清空集合
        arList.clear();
        System.out.println(arList);
    }

}
