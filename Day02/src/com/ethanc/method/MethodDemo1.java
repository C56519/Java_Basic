package com.ethanc.method;

/*
 * 方法：
 * 定义一个方法：
 * 修饰符 返回值类型 方法名(形参列表) {}
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        // 调用方法1
        int a = 1, b = 9;
        int sum = getSum(a, b);
        System.out.println(sum);

        // 调用方法2
        printHelloWorld();
    }

    // 该方法，返回值类型为int
    public static int getSum(int a, int b) {
        return a + b;
    }

    // 该方法，无返回值
    public static void printHelloWorld() {
        System.out.println("Hello World!");
    }
}
