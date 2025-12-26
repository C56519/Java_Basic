package com.ethanc.finaldemo;

// final 关键字：可以修饰类、方法、变量
// 修饰类：该类成为最终类，不能被继承
// 修饰方法：该方法成为最终方法，不能被重写
// 修饰变量：该变量有且仅能被赋值一次。一旦使用final必须赋值
//          变量：1 成员变量：静态成员变量、实例成员变量
//               2 局部变量：方法参数、方法局部变量
//          当final修饰静态变量时，叫做常量
// 注意：1. final修饰基本类型变量，变量存储的数据不能改
//      2. final修饰引用类型变量，变量存储的地址不能改，但地址所指向的引用对象中的数据是可以改的

// 常量：使用 static final 修饰的类变量称为常量
//      通常使用常量来记录系统配置信息
//      命名规范：常量名称建议全大写，多个词用下划线隔开
//                  public static final int CODE_NUMBER = 236687;
//      优势：1. 代码可读性好，可维护性好
//           2. 程序编译后，常量会被宏替换：出现常量的地方全被替换为对应的字面量，保证了使用常量和使用字面量的性能一致
public class FinalDemo1 {
    // 修饰成员变量
    final double rate = 3.14;
    // rate = 8;    无法修改

    // 修饰静态成员变量
    // 常量
    public static final String CARD_ID = "77656";

    public static void main(String[] args) {
        // final修饰引用数据类型
        final int[] arr = new int[]{1, 2, 3, 4};
        arr[0] = 5;
    }

}

// 修饰类
final class A {}
// class B extends A {}

// 修饰方法
class C {
    public final void print() {
        System.out.println("work");
    }
}
/*class D extends C {
    // 会报错，无法重写
    @Override
    public void print() {
        System.out.println("work");
    }
}*/
