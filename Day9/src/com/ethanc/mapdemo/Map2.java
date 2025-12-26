package com.ethanc.mapdemo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
/*
 * Map集合的常用方法
 *
 * 为什么要先学习Map的常用方法？
 * - Map是双列集合的祖宗，它的功能是全部双列集合都可以继承过来使用的。
 *
 * | 方法名称                          | 说明                               |
 * |-----------------------------------|------------------------------------|
 * | public V put(K key,V value)       | 添加元素                           |
 * | public int size()                 | 获取集合的大小                     |
 * | public void clear()               | 清空集合                           |
 * | public boolean isEmpty()          | 判断集合是否为空，为空返回true，反之 |
 * | public V get(Object key)          | 根据键获取对应值                   |
 * | public V remove(Object key)       | 根据键删除整个元素                 |
 * | public boolean containsKey(Object key)   | 判断是否包含某个键         |
 * | public boolean containsValue(Object value) | 判断是否包含某个值       |
 * | public Set<K> keySet()            | 获取全部键的集合                   |
 * | public Collection<V> values()     | 获取Map集合的全部值                |
 */
public class Map2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // .put(key, value) 添加元素
        map.put("王东", 18);
        map.put("孙权", 20);
        map.put("刘备", 19);
        map.put("王东", 19);
        System.out.println(map);    // {孙权=20, 刘备=19, 王东=19}

        // .size() 获取集合的大小 返回值：int
        System.out.println(map.size());

        // .isEmpty() 判断集合是否为空，为空返回true，反之
        System.out.println(map.isEmpty());

        // .get(key) 根据键获取对应的值 返回值：V
        System.out.println(map.get("王东"));

        // .containsKey(key) 判断是否包含某个键  返回值：boolean
        System.out.println(map.containsKey("孙权"));

        // .containsValue(value) 判断是否包含某个值  返回值：boolean
        System.out.println(map.containsValue(100));

        // .keySet() 获取全部键的集合 返回值：Set<K>
        // 这里因为Map集合的key值是唯一的，而Set集合中元素也不会重复，所以放到Set集合中很合适
        Set<String> keySet = map.keySet();  // 获取所有键，组成一个Set集合
        // 遍历Set集合
        for (String key : keySet) {
            System.out.println(key);
        }

        // .values() 获取Map集合的全部值 集合返回值：Collection<V>
        // 这里因为Map集合的value值是可重复的，放到Set集合中，会自动去重，会丢失数据，所以使用了Collection集合接收所有的value值
        Collection<Integer> values = map.values();
        for (Integer v : values) {
            System.out.println(v);
        }

        // .remove(key) 根据键删除整个元素  返回值：要删除元素的value
        System.out.println(map.remove("王东"));

        // .clear() 清空集合
        map.clear();
        System.out.println(map);    // {}
    }
}
