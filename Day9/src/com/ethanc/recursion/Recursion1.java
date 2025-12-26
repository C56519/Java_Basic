package com.ethanc.recursion;
/*
 * 递归：
 * 递归是一种算法，从形式上说，方法调用自身的形式称为方法递归（recursion）。
 *
 * 1 递归的形式：
 *  - 直接递归：方法自己调用自己。
 *  - 间接递归：方法调用其他方法，其他方法又回调方法自己。
 *
 * 2 递归要注意避免死循环而导致栈溢出
 *
 * 3 递归三要素：
 * - 递归的公式：f(n) = f(n-1) * n
 * - 递归的终结点：f(1)
 * - 递归的方向必须走向终结点
 */

public class Recursion1 {
    public static void main(String[] args) {
        // 递归的应用
        System.out.println(factorial(5));
        System.out.println(sum(5));
    }
    // 计算n的阶乘
    public static int factorial(int n) {
        // 当n为1时，因为1乘任何数都为1，所以直接返回1，也作为递归的最内层返回1
        // 当n为0时，因为0乘任何数都为0，所以直接返回0
        // 当n小于0时，因为负数没有阶乘，所以返回-1
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        } else {
            return n * factorial(n-1);
        }
    }
    // 计算1~n的和
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n-1);
        }
    }

}
