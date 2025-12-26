package com.ethanc.method;

/*
 * 方法重载
 * 在Java中，可以用函数重载的方法名来实现一种另辟蹊径的函数拓展功能，通过参数不同来执行函数的不同功能
 * 当同一个类中，使用相同的方法名，却使用不同的参数列表。虽然函数名一致，但调用时，会根据不同的参数来匹配不同的方法。
 * 注意：
 * 1. 方法重载只关心相同的方法名，不同的参数列表，其他无所谓。比如修饰符、返回值可以不同
 * 2. 对于参数列表：数据类型、个数不同就可视为不同。但如果只是顺序、形参名换一下不可视为重载，视为重写。
 */
public class MethodDemo2 {
    public static void main(String[] args) {
    }

    // 方法重载
    public static void print(int a) {
        System.out.println("整数：" + a);
    }
    public static void print(double a) {
        System.out.println("小数：" + a);
    }
    public static void print(String a) {
        System.out.println("字符串：" + a);
    }

    // 解释注意里的第二点
    // 第一个参数是int, 第二个参数是double
    public static void print(int a , double b) {
        System.out.println("两个数：" + a + " " + b);
    }
    // 下面是重复不是重载，因为只是换了下形参名
//    public static void print(int c , double d) {
//        System.out.println("两个数：" + c + " " + d);
//    }
    // 下面也是重复，因为只是将形参顺序换了下
//    public static void print(int b , double a) {
//        System.out.println("两个数：" + b + " " + a);
//    }

    // 这种就是重载，因为第一个参数是double，第二个参数是int
    public static void print(double a , int b) {
        System.out.println("两个数：" + a + " " + b);
    }
}
