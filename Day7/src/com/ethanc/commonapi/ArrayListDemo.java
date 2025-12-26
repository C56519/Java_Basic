package com.ethanc.commonapi;
import java.util.ArrayList;

// List集合
// 与数组比较：数组是静态的，一旦创建，长度就固定了，不能动态扩容，但是ArrayList集合是动态的，可以动态扩容
// 1. 创建一个ArrayList集合对象：ArrayList<dataType> l = new ArrayList<dataType>();
// 2. 常用操作
//      .add(Object obj)    增
//      .remove(int index)      删
//      .set(int index, Object obj)     改
//      .get(int index)     查
//      .size()      获取长度
//      for (int i; i < l.size(); i++) {} 遍历
public class ArrayListDemo {
    public static void main(String[] args) {
        // 1 创建一个ArrayList集合对象
        ArrayList list = new ArrayList();
        // 添加元素
        list.add("hello");
        list.add(1);
        list.add(true);
        // 可见，ArrayList能拓展，内部可添加任意类型的元素
        // 但Java是请类型语言，建议添加的元素类型一致
        // 使用泛型： <数据类型>来贴上标签以规定数据类型一致
        // 也就是ArrayList是泛类型，可以约束其存储的数据类型
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");
        // list1.add(1);    使用泛型后就规定了数据类型

        // 2 常用操作
        // 2.1 添加元素
        // .add(Object obj)     添加元素
        list1.add("world");
        list1.add("abc");
        System.out.println(list1);

        // 2.2 查看元素
        // .get(int index)  获取指定索引位置的元素
        // 返回值：指定索引位置的元素
        System.out.println(list1.get(0));

        // 2.3 遍历
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            System.out.println(s);
        }

        // 2.4 删除数据
        // .remove(int index)   删除指定索引位置的元素，后面元素会前移
        // 返回值：被删除的元素
        list1.remove(0);
        System.out.println(list1);

        // 2.5 修改数据
        // .set(int index, Object obj)  修改指定索引的元素值
        // 返回值：被修改的元素的原来值
        list1.set(1, "XXXX");
        System.out.println(list1);




    }
}
