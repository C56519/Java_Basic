package com.ethanc.collection;
import java.util.ArrayList;
import java.util.HashSet;
//
/*
1 认识集合：集合是一种容器，用来存储数据，但集合大小可变
集合
├── Collection<E>   单列集合：每一个元素只包含一个值
└── Map<E>          双列集合：每个元素包含两个值(键值对)
*/
/*
2 Collection集合家族：

Collection<E>
├── List<E>
│   ├── ArrayList<E>
│   └── LinkedList<E>
└── Set<E>
    ├── HashSet<E>
    │   └── LinkedHashSet<E>
    └── TreeSet<E>
*/
/*
 * 3 Collection集合特点
 *
 * List系列集合: 添加的元素是有序、可重复、有索引
 *   - ArrayList、LinkedList：有序、可重复、有索引
 *
 * Set系列集合: 添加的元素是无序、不重复、无索引
 *   - HashSet: 无序、不重复、无索引
 *   - LinkedHashSet: 有序、不重复、无索引
 *   - TreeSet: 按照大小默认升序排序、不重复、无索引
 */

public class Collection1 {
    public static void main(String[] args) {
        // List - ArrayList
        ArrayList<Integer> arlist = new ArrayList<Integer>();
        // 添加的元素有序、可重复、有索引
        arlist.add(1);
        arlist.add(2);
        arlist.add(2);  // 可重复
        arlist.add(3);
        System.out.println(arlist); // [1, 2, 2, 3] 有序，先添加在前面
        System.out.println(arlist.get(0));  // 能通过索引获取元素，说明有索引

        // Set - HashSet
        HashSet<Integer> hslist = new HashSet<Integer>();
        hslist.add(3);
        hslist.add(2);
        hslist.add(1);
        hslist.add(2);
        System.out.println(hslist); // [1, 2, 3] 先添加的3在后面，无序；添加了两个2，只保留一个2，说明不可重复
        // System.out.println(hslist.get(0));   报错，因为 HahSet是无序的，没有索引
    }
}
