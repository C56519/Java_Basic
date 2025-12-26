package com.ethanc.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Set;
import java.util.Map;


// 终结方法
/*
 * 一旦调用终结操作：
 *   - 流被“消费”并关闭，不能再用；
 *   - 会真正对所有元素进行遍历与运算。
 *
 * 常见终结方法：
 * 1. 遍历：.forEach(Consumer<? super T> action)
 * 2. 统计：.count()
 * 3. 取最大最小：.max(Comparator<? super T> comparator) / .min(Comparator<? super T> comparator)
 * 4. 收集：.collect(Collector)：把流的结果收集到集合、数组、字符串等 。
 *    - Collectors.toList()
 *     - Collectors.toMap()
 *    - Collectors.toSet()
 *    - Collectors.toArray()
 *    - Collectors.joining()
 * 5. 查找匹配：
 *    - anyMatch  ：是否存在某个元素匹配条件
 *    - allMatch  ：是否所有元素都匹配条件
 *    - noneMatch ：是否所有元素都不匹配条件
 *    - findFirst ：找到第一个元素（Optional）
 *    - findAny   ：找到任意一个元素（在并行流下更自由）
 * 6. 归约（折叠计算）：reduce(...)
 *    - 把流中元素反复结合起来，得到一个值（求和、最大值等）。
* */
public class Stream3 {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("张三", 25, 9000));
        teachers.add(new Teacher("李四", 36, 30000));
        teachers.add(new Teacher("王五", 30, 20000));
        teachers.add(new Teacher("赵六", 29, 15000));
        teachers.add(new Teacher("孙七", 31, 25000));

        // 1 .forEach(对每一个元素要进行的操作);    遍历每一个元素
        // 输出所有薪水大于20000的
        teachers.stream().filter(t -> t.getSalary() >= 20000).forEach(System.out::println);

        // .count() 统计个数
        // 返回一个Long类型
        // 统计所有薪水大于20000的
        long count = teachers.stream().filter(t -> t.getSalary() >= 20000).count();

        // 3 .min()/.max() 取最大最小
        // 注意用Optional接收
        Optional<Teacher> max = teachers.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        Optional<Teacher> min = teachers.stream().min((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));

        // 4 .collect() 收集
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(6);
        list.add(7);
        list.add(10);
        Stream<Integer> s1 = list.stream().filter(x -> x >= 5);
        // .collect(Collectors.toList())
        // 会返回一个ArrayList集合
        List<Integer> passList = s1.collect(Collectors.toList());
        System.out.println(passList);

        // .collect(Collectors.toSet())
        // 一个Stream流只能被消费一次，所以上边的S1流是不可以再次调用终结方法
        // 所以现在需要将上边的list集合里的数据放到Set集合中
        // 方法1：使用HashSet的API
        Set<Integer> set1 = new HashSet<>();
        set1.addAll(passList);
        // 方法2：重新创建一个流
        Stream<Integer> s2 = list.stream();
        Set<Integer> set2 = s2.filter(x -> x >= 5).collect(Collectors.toSet());

        // .collect(Collectors.toMap())
        // 参数一：一个抽象函数，返回一个键
        // 参数二：一个抽象函数，返回一个值
        // 由于Map是有键和值，所以转换的时候会出现问题，需要自己指定键和值
        Map<String, Double> m1 = teachers.stream().collect(Collectors.toMap(new Function<Teacher, String>() {
            @Override
            public String apply(Teacher t) {
                return t.getName();
            }
        }, new Function<Teacher, Double>() {
            @Override
            public Double apply(Teacher t) {
                return t.getSalary();
            }
        }));
        // 简写
        Map<String, Double> m2 = teachers.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
    }
}
