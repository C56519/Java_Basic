package com.ethanc.interfacedemo;

// 接口
// 用 interface 关键字修饰
// 特点：
// 1. 是一种特殊的类，JDK8之前，内部只能定义静态成员变量且为常量、抽象方法。此外 public static final、public abstract 可省略不写
// 2. 接口必须有实现类，实现类必须实现接口的所有抽象方法，使用 implements 关键字（注意这里不使用 extends 了）
// 3. 接口类无法创建对象，只能创建相应的实现类对象
// 4. 多实现，一个类可以实现多个接口
// 好处：
// 1. 弥补了单继承的不足，一个类可以实现多个接口，是实现类拥有多个角色，功能更丰富。比如：这个人既是学生，也是助教，又是学生会。
// 2. 实现面向接口编程，更有利于程序解耦。加上多态的支持，更容易切换不同的实现类以满足后续新增、或者完全不同的需求

// 格式：
// 接口类：修饰符 interface 接口名() {}
// 实现类：修饰符 class 实现类名() implements 接口名() {}

// JDK8及之后新增：
// 接口类中可以添加更多的方法了， 1. 默认方法  2. 私有方法  3. 类方法
// 这些新增方法增强了接口的能力，更有利于扩展和维护，比如：一个接口对应了五个实现类，有一天突然要加一个逻辑，那么接口要写一条抽象方法
// 那么五个类都必须重写该方法，难以维护。但是如果使用默认方法，直接将该功能在接口里做完，那么实现类直接调用该方法就可以。

public class Test {
    public static void main(String[] args) {
        // 创建学生对象数组
        Student[] studentlist = new Student[6];
        studentlist[0] = new Student("Tom", "男", 90);
        studentlist[1] = new Student("Jerry", "女", 80);
        studentlist[2] = new Student("Mike", "男", 70);
        studentlist[3] = new Student("Lucy", "女", 60);
        studentlist[4] = new Student("Lily", "女", 50);
        studentlist[5] = new Student("Lucas", "男", 40);

        // 接口实现
        // 这里体现了接口的好处2，搭配多态，实现业务1与业务2的切换，只需要更改实现类名，变量都不用动，解耦思想
        // StudentInter studentImple = new StudentImple1(studentlist);
        StudentInter studentImple = new StudentImple2(studentlist);
        studentImple.printAllInfo();
        System.out.println("===================");
        studentImple.getAvgScore();
    }
}
