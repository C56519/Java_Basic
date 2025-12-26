package com.ethanc.exercises;
import java.util.Scanner;
import java.util.Random;

public class Test2 {
    // 猜数字：1-100之间，随机数，用户输入数字，判断是否猜对，猜大提示过大，猜小提示猜小，猜对则结束
    public static void main(String[] args) {
        guessNum();
    }

    public static void guessNum() {
        // 1 生成随机数
        // 1.1 用Random类
        Random r = new Random();
        // r.nextInt函数参数为区间，写一个就是[0, x)
        int target = r.nextInt(100) + 1;
        // 1.2 用Math.random()
        // Math.random()直接生成一个[0, 1)的double数
        // int target = (int)(Math.random() * 100) + 1;


        // 2 输入输出
        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();

        // 3 死循环判断
        while (guess != target) {
            if (guess > target) {
                System.out.println("猜大了！");
            } else {
                System.out.println("猜小了！");
            }
            System.out.println("请重新输入：");
            guess = sc.nextInt();
        }
        System.out.println("恭喜你猜对了！");
    }
    // 思考：如何使用Random生成65-91的随机数
    // Random区间从零开始生成[0, x)，那么可以先统一减去65，得到[0, 26)区间，再加65，即target = r.nextInt(0, 26) + 65
}
