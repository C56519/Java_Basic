package com.ethanc.singleton;

// 饿汉式单例：拿对象时，已经创建好了对象
// 比如下例：当调用getInstance()方法时，类中已经创建好了对象，保存在成员变量中
public class EagerSingleton {
    // 2. 创建一个静态变量（常量）保存对象，确保只有一个实例，并直接实例化
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // 1. 把类构造器私有
    private EagerSingleton() {}

    // 3. 创建静态方法来返回这个类已经创建好的唯一对象
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
