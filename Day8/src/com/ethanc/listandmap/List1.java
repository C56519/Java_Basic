package com.ethanc.listandmap;
import java.util.List;
import java.util.ArrayList;
/* Colleciton集合下分List和Map集合，而List集合又分为ArrayList和LinkedList，
 * 如果研究List集合，除了它继承了Collection的功能，还有自己的功能。
 *
 * | 方法名称                     | 说明                               |
 * |------------------------------|------------------------------------|
 * | void add(int index,E element)| 在此集合中的指定位置插入指定的元素     |
 * | E remove(int index)          | 删除指定索引处的元素，返回被删除的元素 |
 * | E set(int index,E element)   | 修改指定索引处的元素，返回被修改的元素 |
 * | E get(int index)             | 返回指定索引处的元素               |
 */

public class List1 {
    public static void main(String[] args) {
        // 多态
        List<Integer> list = new ArrayList<Integer>();
        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        // 在指定索引插入元素
        list.add(1, 4);
        System.out.println(list);

        // 其他的方法在ArrayList中已经介绍过了
    }
}
