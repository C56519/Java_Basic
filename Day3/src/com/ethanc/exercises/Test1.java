package com.ethanc.exercises;
import java.util.Scanner;

public class Test1 {
    // 实现一个简单计算器，能执行加减乘除运算
    // 输入两个数字，一个运算符，计算并输出结果
    public static void main(String[] args) {
        // 输入输出
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字1：");
        double a = sc.nextDouble();
        System.out.println("请输入数字2：");
        double b = sc.nextDouble();
        System.out.println("请输入运算符：");
        String op = sc.next();
        // 计算
        calculator(a, b, op);
    }
    public static void calculator(double a, double b, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("除数不能为0！");
                    break;
                }
                result = a / b;
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
        System.out.println(a + op + b + "=" + result);
    }
}
