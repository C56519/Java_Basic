package com.ethanc.mapdemo;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

/*
 * Map集合也被叫做"键值对集合"，格式：{key1=value1，key2=value2，key3=value3，...}
 *
 * Map集合的特点：
 * - 所有的键是不允许重复的，但值可以重复
 * - 键和值是一一对应的，每一个键只能找到自己对应的值
 *
 * Map集合在什么业务场景下使用：
 * - 需要存储一一对应的数据时，就可以考虑使用Map集合来做
 *
 * Map集合的体系
 * Map<K, V>
 * ├── HashMap<K, V>
 * ├── LinkedHashMap<K, V>
 * └── TreeMap<K, V>
 *
 * Map集合体系的特点：
 * 注意：Map系列集合的特点都是由键决定的，值只是一个附属品，值是不做要求的。
 *
 * - HashMap（由键决定特点）：无序、不重复、无索引；（用的最多）
 * - LinkedHashMap（由键决定特点）：有序、不重复、无索引。
 * - TreeMap（由键决定特点）：按照大小默认升序排序、不重复、无索引。
 */
public class Map1 {
    public static void main(String[] args) {
        // 创建HashMap集合
        Map<String, Integer> map = new HashMap<>();

        // .put(key, value) 添加元素
        map.put("王东", 18);
        map.put("孙权", 20);
        map.put("刘备", 19);
        map.put("王东", 19);
        map.put(null, null);
        System.out.println(map);    // {null=null, 孙权=20, 刘备=19, 王东=19}
        // 可见HashMap特点：无序、key不重复、无索引、键值对都可以是null

        // 创建LinkedHashMap集合
        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("王东", 18);
        map1.put("孙权", 20);
        map1.put("刘备", 19);
        map1.put("王东", 19);
        map1.put(null, null);
        System.out.println(map1);   // {王东=19, 孙权=20, 刘备=19, null=null}
        //可见LinkedHashMap特点：有序、key不重复、无索引、键值对都可以是null
    }
}
