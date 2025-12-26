package com.ethanc.singleton;

// 懒汉式单例：拿对象时，才去创建对象

public class LazySingleton {
    // 2 创建一个静态成员变量用来存储实例对象
    private static LazySingleton instance;
    // 1 将构造器私有
    private LazySingleton() {}
    // 3 创建一个静态方法来返回该类的唯一实例对象
    public static LazySingleton getInstance() {
        // 检查此类是否生成过对象，确保对象唯一
        // 如果没有则创建，如果有，则直接返回已经创建好的
        if (instance == null) {
            // 创建对象
            instance = new LazySingleton();
        }
        return instance;
    }
}
