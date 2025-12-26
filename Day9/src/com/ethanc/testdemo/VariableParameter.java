package com.ethanc.testdemo;

import java.util.Arrays;

/*
 * 1 方法中可变参数
 * - 就是一种特殊形参，定义在方法、构造器的形参列表里，格式是：数据类型...参数名称；
 *
 * 1.1 可变参数的特点和好处
 * - 主要在不确定参数数量时用
 * - 特点：可以不传数据给它；可以传一个或者同时传多个数据给它；也可以传一个数组给它。
 * - 好处：常常用来灵活的接收数据，可以替代数组传参
 *
 * 1.2 如何使用传入的可变参数：可变参数实际上就是一个数组
 *
 * 1.3 注意：
 * - 可变参数在形参列表中只能存在一个，且只能是形参列表的最后一个参数
 */
public class VariableParameter {
    public static void main(String[] args) {
        sum(1); // 传入一个数
        sum(1, 2);  // 传入多个数
        sum(new int[]{1, 2, 3});    // 传入一个数组
    }

    // 可变参数
    public static void sum(int ...nums) {
        // 可变参数实际上就是一个数组
        System.out.println(nums.length);
        System.out.println((Arrays.toString(nums)));
        System.out.println();
    }
}
