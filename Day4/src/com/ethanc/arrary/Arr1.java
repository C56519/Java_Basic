package com.ethanc.arrary;
import java.util.Scanner;

public class Arr1 {
    public static void main(String[] args) {
        arrDemo1();
        // arrDemo2();
        arrDemo3();
    }

    // 1 定义一个数组
    // 1.1 静态初始化数组：定义时已经确定了数据
    // 数据类型[] 数组名 = {元素1, 元素2, 元素3, ...}
    // 完整格式：数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, 元素3, ...}
    // 注意：数据类型[] 数组名也可以写成 数据类型 数组名[]

    // 1.2 动态初始化数组：定义时没有确定数据
    // 只确定数组的类型和长度，不事先指定数据
    // 数据类型[] 数组名 = new 数据类型[数组长度]

    // 2 二维数组
    // 定义方法与一维相似：也分静态动态
    // 数据类型[][] 数组名 = new 数据类型[][]{{元素1}, {元素2, 元素3}, ...}

    // 1.1 静态数组
    public static void arrDemo1() {
        // 初始化一个静态数组
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
        // 访问数组元素
        System.out.println(arr1[0]);
        // 获取数组长度
        System.out.println(arr2.length);
    }

    // 1.2 动态数组
    // 录入五个学生的成绩放到数组，并求出平均分，最高分
    public static void arrDemo2() {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        double max = 0.0;
        // 初始化一个动态数组
        double[] score = new double[5];
        // 实际上也是在内存中开辟了空间，往里存了数据，只不过存了8个默认值0.0

        // 录入数据
        for (int i = 0; i < score.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
            score[i] = sc.nextDouble();
        }

        // 计算平均分，最高分
        double temp = 0.0;
        for (int i = 0; i < score.length; i++) {
            // 为什么定义了这个变量，为了避免重复查找数组
            temp = score[i];
            sum += temp;
            if (temp > max) {
                max = temp;
            }
        }
        double avg = sum / score.length;
        System.out.println("平均分：" + avg);
        System.out.println("最高分：" + max);
    }

    // 2 二维数组
    public static void arrDemo3() {
        // 初始化
        int[][] arr1 = new int[3][5];
        int[][] arr2 = new int[][]{
                {1, 2},
                {4, 5, 6},
                {7, 8, 9, 10}
        };
        // 访问
        System.out.println(arr2[0][1]);
        // 遍历
        // 先行遍历
        for (int i = 0; i < arr2.length; i++) {
            // 遍历行中的每列元素
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
