package com.ethanc.throwabledemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 异常
// 从结构上来看：java.lang.Throwable 是异常类的根类，下分类有 Exception 和 Error 两类
// 1. Error：错误。 代表系统级别的错误，属于严重错误，Sun公司会把系统出现的问题封装成Error对象给出来，但开发者用户一般不需要用
// 2. Exception：异常。下分 RuntimeException 和 其他异常 两类
//               它代表的才是我们程序可能出现的问题，所以，我们程序员通常会用Exception以及它的孩子来封装程序出现的问题。
//               运行时异常: RuntimeException及其子类，编译阶段不会出现错误提醒，运行时出现的异常（如：数组索引越界异常）
//               编译时异常: 编译阶段就会出现错误提醒的。（如：日期解析异常）
// 开发中，大多抛出运行式异常
// 作用：
//      1. 用来定位程序bug的关键信息
//      2. 可以作为方法内部的一种特殊返回值，以便通知上层调用者，方法的执行有问题
public class ExceptionDemo1 {
    public static void main(String[] args) {
        // 运行时异常
        // test1();

        // 编译时异常
        // 因为选择了throw，所以这里会抛给调用者test2。需要处理异常
        // 使用try catch处理
        // 监视代码：先尝试运行，如果出现异常，会被catch捕捉
        try {
            test2();
        } catch(ParseException e) {
            e.printStackTrace();    // 打印异常信息
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 如果两个异常都抛给Exception，直接catch Exception 就可以了，不用catch两个
        try {
            test2();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 运行时异常：编译时不会报错，运行时才会报错的异常，继承自 RuntimeException
    public static void test1() {
        System.out.println("程序开始");
        int[] arr = {1, 2, 3};
        // System.out.println(arr[3]); // ArrayIndexOutOfBoundsException 索引越界异常

        // System.out.println(10/0);   // ArithmeticException  算术异常

        String str = null;
        System.out.println(str);
        System.out.println(str.length());   // NullPointerException 空指针异常

        System.out.println("程序结束"); // 异常出现，后面代码不会执行
    }

    // 编译时异常：编译时就报错，继承自 Exception
    // 下面程序处理了两个编译异常，选择throws处理，抛出了两个异常，但是可直接抛给Exception，因为Exception是他们的父类
    // 如：public static void test2() throws Exception {...}  这样只写一个就可以
    public static void test2() throws ParseException, FileNotFoundException {
        // 1 第一个编译异常 ParseException
        System.out.println("程序开始");
        String str = "2025-11-14";
        // 可以把字符串信息解析为一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str); // 编译异常，提醒开发者这里的程序很容易出错，引起注意
        // 因为str与SimpleDateFormat的参数一旦匹配不上，就报错，所以这里就算对了也会抛出编译异常，它担心你错
        // 鼠标移动道标红的sdf.parse(str)上，Alt + Enter，选择throws处理，会将错误抛给调用者处理

        // 2 第二个编译异常 FileNotFoundException
        // 会标红，担心你文件路径出错
        // 同理选择处理，用throws抛出
        InputStream i = new FileInputStream("D:/test.txt");

        System.out.println(date);
        System.out.println("程序结束");
    }
}
