package com.ethanc.generics;

import java.util.ArrayList;

// 泛型
// 定义：在定义类、接口、方法时，同时声明了一个或者多个类型变量（如：<E>）称为泛型类、泛型接口，泛型方法、它们统称为泛型。
// 写法：public class ArrayList<E> {...}   相当于加了个标签
// 作用：泛型提供了在编译阶段约束所能操作的数据类型，并自动进行检查的能力。这样可以避免强制类型转换，及其可能出现的异常。
// 本质：就是把具体的数据类型作为参数传给类型变量
// 怎么自定义泛型类？
// 1. 泛型类
// 修饰符 class 类名<类型变量, 类型变量, ...> {}
// 注意：类型变量建议用大写字母，E(元素的类型)，T(返回值类型)，K(键类型)，V(值类型)等

// 2. 泛型接口
// 修饰符 interface 接口名<类型变量, 类型变量, ...> {}
public class Generics1 {
    // 自定义泛型类
    // 需求：请自定义一个集合，来加强AarrayList类的功能，比如添加数据时返回添加成功或者失败

}

class mockArrayList<E> {
    // 装饰设计模式：先用别人的类，在他的基础上，再进行自己的扩展
    private ArrayList arrlist = new ArrayList();

    // 可以看出，泛型的E就是代表了一个数据类型符号，如 int i, String s
    // 其实泛型可以这么理解，当数据类型不确定时，可以用变量的思想，比如设置为类型变量，那么它传什么类型，就是什么类型
    public boolean add(E e) {
        arrlist.add(e);
        return true;
    }
}