package com.ethanc.mapdemo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * Map集合的遍历方式
 * 1. 键找值：先获取Map集合全部的键，再通过遍历键来找值
 *      - 先用.keySet()方法获取Map集合的全部键，并存到一个Set集合中
 *      - 然后用for循环遍历Set集合中的键，再通过get(key)方法获取对应的值
 * 2. 键值对：把"键值对"看成一个整体进行遍历（难度较大，基于源码理解）
 *      - 使用 .entrySet()方法获取Map集合的全部键值对：Set<Map.Entry<K, V>> 变量名 = Map名.entrySet();
 *      - 以 HashMap 为例：底层使用一个 Node<K,V>[] table 数组来存储键值对。每个数组槽位（bucket）里是一个链表或红黑树，节点类型是 Node<K,V>（或树化后为 TreeNode<K,V>）。
 *        如，Node<K,V> 这个内部类实现了为方便遍历而对外暴露的 Map.Entry<K,V> 类型的接口，因此每个节点对象既承担“存储键值对”的角色，又可以被当作一个 Map.Entry<K,V> 类型的对象来使用
 *        （一个实现类可以实现多个接口，所以每个节点对象本身也有 Map.Entry<K,V> 的这个身份）。
 *
 *      - 调用 map.entrySet() 会得到一个 Set<Map.Entry<K,V>> 类型的“视图集合”，其中每个元素都是一个Map.Entry<K,V> 类型的对象。
 *        在遍历时，直接查询 HashMap 那些节点。通过对这个对象调用 getKey() 和 getValue()，就能访问到这一组键和值。
 * 3. .forEach() + Lambda表达式：JDK 1.8开始之后的新技术（非常的简单）
 *         map1.forEach((k, v) -> System.out.println(k + "=" + v));
 */

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Map3 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("王东", 18);
        map1.put("孙权", 20);
        map1.put("刘备", 19);

        // 遍历方式1
        Set<String> keySet = map1.keySet();
        for (String key : keySet) {
            Integer value = map1.get(key);
            System.out.println(key + "=" + value);
        }

        // 遍历方式2
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        for (Map.Entry<String, Integer> kv : entries) {
            String thisKey = kv.getKey();
            Integer thisValue = kv.getValue();
            System.out.println(thisKey + "=" + thisValue);
        }

        // 遍历方式3
        // map名.forEach(new BiConsumer<K, V>() {重写accept(K k, V v)方法})
        // 源码：.forEach()方法内部是使用了 .entrySet()方法遍历，在遍历时，会先拿到键和值，然后调用了 BiConsumer接口的accept()方法
        // 重写该方法以执行遍历中需要执行的逻辑
        map1.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key + "=" + value);
            }
        });
        // 可简写为：
        map1.forEach((k, v) -> System.out.println(k + "=" + v));

        // 练习
        // 某个班级80名学生，现在需要投票选出一个班长，现有四个候选人依次是 (A、B、C、D)，每个学生只能投一个票，请统计出最终哪个候选人获胜。
        // 1. 获得所有投票
        List<String> votes = getAllVotes();
        // 2. 统计投票结果
        countVotes(votes);


    }

    /**
     * 获取所有投票
     * @return 所有投票的List集合
     */
    public static List<String> getAllVotes() {
        // 将所有投票放到一个集合中
        List<String> votes = new ArrayList<>();
        // 随机造票
        String[] people = {"A", "B", "C", "D"};
        Random random = new Random(42); // 设置随机数种子
        for (int i = 0; i < 80; i++) {
            int peopleIndex = random.nextInt(people.length);    //  random.nextInt(4) 随机生成[0, 4) 的整数
            votes.add(people[peopleIndex]);
        }
        return votes;
    }

    /**
     * 统计并打印投票结果
     * @param votes 所有投票的List集合
     */
    public static void countVotes(List<String> votes) {
        // 创建一个Map集合，用于统计投票结果
        Map<String, Integer> staMap = new HashMap<>();
        for (String vote : votes) {
/*            if (staMap.containsKey(vote)) {
                staMap.put(vote, staMap.get(vote) + 1);
            } else {
                staMap.put(vote, 1);
            }*/
            // 简化
            staMap.put(vote, staMap.containsKey(vote)
                    ? staMap.get(vote) + 1
                    : 1);
        }
        // 遍历Map集合，打印统计结果
        staMap.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
