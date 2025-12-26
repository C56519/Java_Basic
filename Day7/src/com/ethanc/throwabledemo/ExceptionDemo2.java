package com.ethanc.throwabledemo;
// 异常的作用：
//      1. 用来定位程序bug的关键信息
//      2. 可以作为方法内部的一种特殊返回值，以便通知上层调用者，方法的执行有问题 throw new Exception("XXX")
public class ExceptionDemo2 {
    public static void main(String[] args) {
        // 2 当底层函数抛给上层的调用者int a = test1(10, 0) 时，会标红，也就是提醒你底层代码可能会出问题
        // int a = test1(10, 0);
        // 这时用try catch处理
        try {
            int a = test1(10, 0);
            System.out.println("底层方法执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败");
        }
    }
    public static int test1(int x, int y) throws Exception {
        if (y == 0) {
            System.out.println("除数不能为0");
            // 1 函数返回值规定为 int，当除数为零时，应直接return，但要求返回一个int型，那么有些人会返回个-1代表异常
            // 这里也可不用return，用 throw new Exception("自定义的异常提醒语句") 来创建一个Exception异常对象，并抛给上层调用者
            throw new Exception("除数不能为0");
        }
        return x / y;

    }
}
