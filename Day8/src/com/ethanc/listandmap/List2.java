package com.ethanc.listandmap;
import java.util.LinkedList;

// List集合: 分为ArrayList和LinkedList两种
// 两者区别：二者底层采用的数据结构不同，应用场景不同
/*
 * 1 ArrayList的底层原理：
 * - ArrayList底层是基于数组存储数据的。
 *
 * 1.2 数组与链表对比：
 *          查询速度快（注意：是根据索引查询数据快）：查询数据通过地址值和索引定位，查询任意数据耗时相同。
 *          增删数据效率低：可能需要把后面很多的数据进行前移。
 *     链表与数组对比：
 *          链表的特点1：查询慢，无论查询哪个数据都要从头开始找。
 *          链表的特点2：链表增删相对快
 * 源码上，ArrayList的底层数组是Object[]，首次未添加元素前始长度为10，扩容规则是：每次扩容为当前长度的1.5倍
 */

/*
 * 2 LinkedList的底层原理
 * - LinkedList底层是基于双向链表存储数据的。
 *
 * 2.1 链表分类：单向链表、双向链表、循环链表
 *
 * 2.2 单向链表
 * 2.2.1 特点：
 * - 链表中的数据是一个一个独立的结点组成的，
 *   结点在内存中是不连续的，每个结点包含数据值和下一个结点的地址。
 * 2.2.2 单向常用链表操作
 * 在链表数据BD之间添加一个数据C
 *   ① 将数据C对应的下一个数据地址指向数据D
 *   ② 将数据B对应的下一个数据地址指向数据C
 * 删除链表数据CE之间的数据D
 *   ① 数据C对应的下一个数据地址，并使其指向数据E
 *   ② 删除数据D
 *
 * 2.3 双向链表
 * 2.3.1 特点：
 * - 链表中的数据是一个一个独立的结点组成的，结点在内存中是不连续的，每个结点包含数据值、下一个结点的地址、上一个结点的地址。
 * - 与单向链表相比，双向链表对首尾元素进行增删改查速度有提升
 */
/*
 * 2.4 LinkedList特有方法：
 *
 * | 方法名称                  | 说明                           |
 * |---------------------------|--------------------------------|
 * | public void addFirst(E e) | 在该列表开头插入指定的元素       |
 * | public void addLast(E e)  | 将指定的元素追加到此列表的末尾   |
 * | public E getFirst()       | 返回此列表中的第一个元素         |
 * | public E getLast()        | 返回此列表中的最后一个元素       |
 * | public E removeFirst()    | 从此列表中删除并返回第一个元素   |
 * | public E removeLast()     | 从此列表中删除并返回最后一个元素 |
 */

// 2.4.1 LinkedList的应用场景
// a. 做队列：入队和出队操作，遵循先入先出的原则，所以对首尾操作非常频繁，这种就非常适合双链表数据结构，LinkedList
// b. 做栈：进栈和出栈操作，遵循后入先出的原则，同样是频繁进行首尾操作
public class List2 {
    public static void main(String[] args) {
        // 创建队列
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // 模拟入队操作
        System.out.println("入队操作");
        queue.addLast(1);
        System.out.println(queue);
        queue.addLast(2);
        System.out.println(queue);
        queue.addLast(3);
        System.out.println(queue);

        // 模拟出队操作
        System.out.println("出队操作");
        queue.removeFirst();
        System.out.println(queue);
        queue.removeFirst();
        System.out.println(queue);

        // 创建栈
        LinkedList<Integer> stack = new LinkedList<Integer>();

        // 模拟入栈操作
        System.out.println("入栈操作");
        stack.addLast(1);
        System.out.println(stack);
        stack.addLast(2);
        System.out.println(stack);
        stack.addLast(3);
        System.out.println(stack);

        // 模拟出栈操作
        System.out.println("出栈操作");
        stack.removeLast();
        System.out.println(stack);
        stack.removeLast();
        System.out.println(stack);
    }
}
