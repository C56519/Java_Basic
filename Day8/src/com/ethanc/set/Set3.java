package com.ethanc.set;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * 1 LinkedHashSet的底层原理
 *
 * - 依然是基于哈希表(数组、链表、红黑树)实现的。
 * - 但是，它的每个元素都额外的多了一个双链表的机制记录它前后元素的位置。
 *      也就是逻辑上可以这么理解：在原有HashSet的基础上，单独加了个双链表逻辑
 * 看源码发现它是基于LinkedHashMap来实现的
 */

/*
 * TreeSet特点：
 * - 不重复、无索引、可排序（默认升序排序，按照元素的大小，由小到大排序）
 * - 底层是基于红黑树实现的排序。（比如：先加的为根节点，然后根据大小，确定是存左边还是右边）
 *
 * 注意：
 * - 对于数值类型：Integer，Double，默认按照数值本身的大小进行升序排序。
 * - 对于字符串类型：默认按照首字符的编号升序排序。
 * - 对于自定义类型如Student对象，TreeSet默认是无法直接排序的。（给个对象，它不清楚排序逻辑，是按照年龄、成绩等）
 *
 * 所以针对自定义类型如Student对象，引入自定义排序规则：
 * TreeSet集合存储自定义类型的对象时，必须指定排序规则，支持如下两种方式来指定比较规则。
 * 方式一：让自定义的类（如学生类）实现Comparable接口，重写里面的compareTo方法来指定比较规则。
 * 方式二：通过调用TreeSet集合有参数构造器，可以设置Comparator对象（比较器对象，用于指定比较规则）。
 *         public TreeSet(Comparator<? super E> comparator)
 *
 * 两种方式中，关于返回值的规则：
 * - 如果认为第一个元素 > 第二个元素 返回正整数即可。
 * - 如果认为第一个元素 < 第二个元素 返回负整数即可。
 * - 如果认为第一个元素 = 第二个元素 返回0即可，此时TreeSet集合只会保留一个元素，认为两者重复。
 *
 * 注意：如果类本身有实现Comparable接口，TreeSet集合同时也自带比较器，默认使用集合自带的比较器排序。
 */
public class Set3 {
    public static void main(String[] args) {
        // 探究TreeSet集合
        Set<Teacher> tSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                // 按照年龄排序
                // return o1.getAge() - o2.getAge();

                // 如果按salary排序，因为compare规定了返回值为int，而如果还是用这种减的逻辑返回值为double
                // 可以用if else笨办法来写，但也可以调用包装类Double.compare()方法
                // Double.compare(a, b)
                // 参数为两个double类型
                // 返回值： int类型，如果a>b，则返回一个正整数；如果a<b，则返回一个负整数，如果a=b，则返回0。
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        tSet.add(new Teacher("李强", 25, 5230.5));
        tSet.add(new Teacher("王东", 30, 7562.56));
        tSet.add(new Teacher("张菲", 28, 7487.5));
        tSet.add(new Teacher("刘业", 35, 12000));

        // System.out.println(tSet.toString()); // 报错，因为存入TreeSet中的是四个Teacher对象，它不清楚排序逻辑

        // 解决方案：
        // 1. 让Teacher类实现Comparable接口，并重写compareTo方法，指定比较规则
        // System.out.println(tSet.toString());
        // 2. 通过调用TreeSet集合有参数构造器，可以设置Comparator对象，他是个函数式接口，重写compare方法，指定比较规则
        System.out.println(tSet.toString());
        // 可以用Lambda表达式简写
        // Set<Teacher> tSet2 = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
    }

}
