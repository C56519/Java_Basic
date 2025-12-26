package com.ethanc.throwabledemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

// 处理异常的方案
// 1. 从底层代码入手，在底层代码里一层一层向上层抛出异常，在最外层捕获异常。记录并打印出异常信息（一般开发中都存到日志中）
// 2. 从最外层代码入手，底层代码不做异常判断，在最外层用try-catch做异常判断，捕获异常后，再尝试修复
public class ExceptionDemo4 {
    public static void main(String[] args) {
        // 由于选择向上抛出异常的方法来处理，那么最顶层要处理这个异常
        try {
            test1();
        } catch (FileNotFoundException e){
            // 捕获到异常后，做打印异常栈的操作
            e.printStackTrace();
        }

        // 由于选择最外层处理异常的方案，所以最顶层要处理
        try {
            test2();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    // 方法一：从底层代码入手，向上抛出
    public static void test1() throws FileNotFoundException {
        // 一旦找不到文件，系统会给异常，这里选择直接向上抛出
        InputStream is = new FileInputStream("D:/test.txt");
    }

    // 方法二：从最外层代码入手，最外层用try-catch处理异常，底层不做异常判断
    public static void test2() {
        System.out.println("请输入存钱数额：");
        Scanner sc = new Scanner(System.in);
        // 由于用nextDouble，所以一旦输入不是Double，系统会报错
        double money = sc.nextDouble();
    }
}
