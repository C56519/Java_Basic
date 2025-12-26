package com.ethanc.generics;

// 1 包装类：把基本数据类型包装成对象
// 为什么要包装类？
// 从泛型的特点入手：泛型不支持基本数据类型，只支持引用数据类型
// 理解：泛型在编译时，会执行泛型擦除：泛型工作在编译阶段，等编译后泛型就没用了，所以泛型在编译后都会被擦除，所有类型都会变成Object类型
//      所以当编译完，如果给泛型指定基本数据类型 Object o = 12 用Object接收一个基本数据类型是不可能的
//      所以，为了规范又能支持多数据类型，那就将基本数据类型包装成对象，这就是包装类的作用
// ArrayList<int> list = new ArrayList<Integer>();  非法
// ArrayList<Integer> list = new ArrayList<Integer>();  合法
// 基本数据类型  包装类
// byte      Byte
// short     Short
// int       Integer
// long      Long
// float     Float
// double    Double
// char      Character
// boolean    Boolean

import java.util.ArrayList;

// 2 基本数据类型转换成包装类对象
// 2.1 手动转换：.valueOf()  可以将基本数据类型转换成包装类对象，也可以通过包装类对象转换成基本数据类型
// 2.2 自动转换：自动装箱，自动拆箱。基本数据类型可以自动转换为包装类型，包装类型可以自动转换为基本数据类型

// 3 包装类的功能
// 3.1 .toString() 可以把基本类型的数据，转成字符串
// 3.2 .parseInt() 可以把字符串转换成基本数据类型 还有.parseLong() .parseDouble()等
//      其实可以直接用 .valueOf() 这样就不用分类型了，直接将字符串转换成各自数值类型
public class Generics5 {
    public static void main(String[] args) {
        // 将基本数据类型变成包装类对象
        // 1 手动转换：.valueOf()
        // 注意：源码为了节省内存，会自动缓存-128到127的数字，所以，如果传入的数字在-128到127之间，那么返回的Integer对象是同一个对象
        Integer i = Integer.valueOf(12);
        Integer i2 = Integer.valueOf(12);
        Integer i3 = Integer.valueOf(130);
        System.out.println(i == i2);    // true 表明两个包装类对象用的是用一个地址
        System.out.println(i == i3);    // false
        int x = i.intValue(); // 将基本数据类型转换为包装类型
        System.out.println(x);

        // 2 自动转换
        // 自动装箱：基本数据类型可以自动转换为包装类型
        Integer i4 = 100;
        Integer i5 = 100;
        System.out.println(i4 == i5);   // true
        // 自动拆箱：包装类型可以自动转换为基本数据类型
        int a = i4;
        System.out.println(a);

        // 理解
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(200);  // 不用我们自己转换，直接自动装箱成Integer对象传入集合

        int b =list.get(0); // 自动拆箱，自动将Integer对象转换成int

        // 3 包装类的功能
        // 3.1 .toString()
        String s = i4.toString();
        System.out.println(s);

        // 3.2 .parseInt()
        int c = Integer.parseInt("123");
        System.out.println(c);
        double d = Double.parseDouble("123.456");
        System.out.println(d);
        // 可直接用 .valueOf()
        int e = Integer.valueOf("123");
        System.out.println(e);
        double f = Double.valueOf("123.456");
        System.out.println(f);
    }
}
