package com.ethanc.obj3;

// 代码块
// 类中的五大成分：成员变量（静态、实例）、方法（静态、实例）、构造器方法、代码块、内部类
// 代码块的分类：1. 静态代码块 2. 实例代码块
// 1. 静态代码块：
//      格式：static {}
//      特点：类加载时自动执行，由于类只会加载一次，所以静态代码块也只会执行一次。
//      作用：完成类的初始化，例如：对静态变量的初始化赋值。
// 2. 实例代码块：
//      格式：{}
//      特点： 每次创建对象时，执行实例代码块，并在构造器前执行。
//      作用： 和构造器一样，都是用来完成对象的初始化的，例如：对实例变量进行初始化赋值。
public class CodeBlock {
    private static int num;
    // 静态代码块
    static {
        // 在加载类的时候就执行，顺序优于main方法
        System.out.println("静态代码块执行");
        num = 10;
    }
    // 实例代码块
    {
        // 只在创建对象时执行一次，顺序优于构造器
        System.out.println("实例代码块执行");
    }
    // 构造器
    public CodeBlock() {
        System.out.println("构造器执行");
    }
    public static void main(String[] args) {
        System.out.println("main方法执行");
        new CodeBlock();
    }
}
