package com.ethanc.singleton;

// 设计模式
// 一个问题有n种解法，最优的那种解法成为设计模式。软件有20多种设计模式，对应开发中会遇到的问题
// 关于设计模式学什么？解决什么问题 + 怎么写

// 单例设计模式
// 作用：确保某个类只能创建一个对象，比如一个程序开一次就够了，防止多开浪费内存
// 写法：
//      1. 把类构造器私有
//      2. 创建一个静态成员变量保存对象
//      3. 创建一个静态方法返回对象
public class Test {
    public static void main(String[] args) {
        // 饿汉式单例
        // 使用单例类EagerSingleton创建两次对象
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance1 == instance2); // true 说明该类不管调用多少次，返回的是同一个对象

        // 懒汉式单例
        LazySingleton instance3 = LazySingleton.getInstance();
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println(instance3 == instance4); // true
    }
}
