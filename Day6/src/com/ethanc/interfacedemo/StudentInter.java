package com.ethanc.interfacedemo;

// 接口类
// 一般命名以Inter做后缀
public interface StudentInter {
    // 静态成员变量都是常量
    // 可省略 public static final
    // int CODE_QR = 903478;

    // 接口方法
    // 可省略 public abstract
    void printAllInfo();

    void getAvgScore();

    // 只做示例：
    // JDK8及之后新增
    // 1. 默认方法（实例方法）：使用关键字 defualt 修饰，可省略 public，只能被实现类对象调用
    default void show() {}
    // 2. 私有方法
    private void show2() {}
    // 3. 类方法（静态方法）：可省略 public，与继承里的静态方法不同，继承里调用时有两种
    // 父类.静态方法名 或 子类.静态方法名 这两种方法都可以调用
    // 但接口的类方法，只能通过 接口类名.静态方法名 调用
    static void show3() {}
}
