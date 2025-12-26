package com.ethanc.throwabledemo;

// 自定义异常
// Java无法为这个世界上全部的问题都提供异常类来代表，如果企业自己的某种问题，想通过异常来表示，以便用异常来管理该问题，那就需要自己来定义异常类了。

// 观察异常的继承树，可知基本上自定义异常就是在RuntimeException与Exception之下定义
// 分类：自定义运行时异常，自定义编译时异常
// 1 自定义运行时异常
// 方法：
// a. 定义一个异常类继承RuntimeException
// b.重写构造器
// c.通过 throw new 异常类(xxx)来创建异常对象并抛出。
//特点：编译阶段不报错，运行时才可能出现！提醒不属于激进型。

// 2 自定义编译时异常
// a. 定义一个异常类继承Exception。
// b.重写构造器。
// c.通过throw new 异常类(xxx)创建异常对象并抛出。
//特点：编译阶段就报错，提醒比较激进
public class ExceptionDemo3 {
    public static void main(String[] args) {
        // 上层调用者

        // 运行时异常
        printAge(300);

        // 编译时异常
        try {
            printAge2(-100);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    // 底层逻辑函数
    // 1 自定义运行时异常
    public static void printAge(int age) {
        if (age < 0 || age > 200) {
            // 使用自定义异常：用throw new 自定义异常     来抛出异常
            throw new CustomRuntimeExceptions("自定义运行时异常：年龄超过界限(0-200)");
        }
        System.out.println("Your age is: " +  age);
    }

    // 2 自定义编译时异常
    public static void printAge2(int age) throws CustomException {
        if (age < 0 || age > 200) {
            // 使用自定义异常：用throw new 自定义异常     来抛出异常
            // 自定义编译时异常要额外在此方法的声明行抛出异常
            throw new CustomException("自定义编译时异常：年龄超过界限(0-200)");
        }
        System.out.println("Your age is: " +  age);
    }
}
