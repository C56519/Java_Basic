package com.ethanc.generics;

import java.util.ArrayList;

// 通配符
// 定义：可以在使用泛型时表示一切类型
// 分类：无界通配符(?)，上界通配符(? extends T)，下界通配符(? super T)
// <?> 表示接收任何类型
// <? extends T> ：表示接收T类型或T类型的子类（也就是接收的类型不能超过T类型，比如设置T为Number，那么可以接收int,double等，但无法接收String）
// <? super T> ：表示接收T类型或T类型的父类（也就是接收的类型不能小于T类型，比如设置T为double，那么可以接收double, Number, Object）
public class Generics4 {
    public static void main(String[] args) {
        // 三种类型的ArrayList，要求定义一个方法，来输出这三个类型的集合的所有数据

        // 创建集合并数据准备
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Boolean> list3 = new ArrayList<Boolean>();
        list1.add("hello");
        list2.add(16);
        list3.add(true);

        showData(list1);
        showData(list2);
        showData(list3);

        // showData2(list1);    会报错，因为设置了上界为 Number，所以不接受String类型
        showData2(list2);

        // showData3(list1);    会报错，因为设置了下界为 Byte
        // showData3(list2);    同样会报错

    }

    // 无界通配符
    // 注意这里是在使用泛型ArrayList<?> list，因为ArrayList早就被定义好了，而不是定义泛型，所以可用?，而不能用T，T那些是在定义泛型时使用的
    public static void showData(ArrayList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 设置上界
    public static void showData2(ArrayList<? extends Number> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 设置下界
    // 设置下界为 Byte，所以只能接受Byte，Number，Object
    public static void showData3(ArrayList<? super Byte> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
