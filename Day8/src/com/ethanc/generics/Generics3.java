package com.ethanc.generics;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

// 泛型方法
// 定义：Java中的方法都是强制指定类型的，需要一种通配的方法，接收任何类型，都能执行逻辑，使用泛型方法
// 格式：修饰符 <类型变量, 类型变量, ...> 返回值类型 方法名(参数列表) {... }
public class Generics3 {
    public static void main(String[] args) {
        // 如：定义一个方法，功能是打印所有数组元素。
        // 由于Java中方法在声明时强制指定类型，那么这个打印数组元素的逻辑就只能用于指定类型
        // 这就有问题，比如，一个int型数组，一个double型数组，打印元素逻辑相同，但因为强制指定类型，就需要定义两个方法
        // 这时候使用泛型方法，就能用一个通配方法，解决问题
        Integer[] arr1 = {1, 2, 3, 4, 5};
        String[] arr2 = {"1", "2", "3", "4", "5"};
        printArrElements(arr1);
        printArrElements(arr2);
    }

    /**
     * 解读：
     * 功能：打印所有数组元素
     * 泛型：E类型
     * 返回值：void
     * 参数：E[] arr 表示，参数的数据类型是一个E类型的数组，参数名为arr
    */
    public static <E> void printArrElements(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
}
