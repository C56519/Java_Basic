package com.ethanc.datatype;

// 数据类型转换
// 分类：自动类型转换，强制类型转换
// 1. 自动类型转换：
// 当两个不同数据类型进行计算时，会根据数据大小关系，小的自动转换成大的：byte -> short -> int -> long -> float -> double
// 当byte、short以及char参与计算时，会自动转换成int，再进行计算。一般是进行前面补零操作。此外char一般对应ASCII码参与计算

// 2. 强制类型转换：
// 强行转换数据类型：byte a = (byte) 1200
// 2.1 当数据类型转换时，可能会丢失数据而数据溢出。
// 比如byte的范围是-128~127，将1200转换为byte类型时，会变成-80。
// 具体计算：1200的二进制是10010110000，有11位，而byte最大是八位，所以舍掉高位，只留八位，变成10110000，第一位为符号位，1为负数
// 对于负数，计算机是按照补码的方式存储的，所以先取反，01001111，再加1，01010000，对应十进制80，而又因为是负数，得-80

// 2.2 小数强行转成整数时，会直接丢掉小数部分。

public class DataConvert {
    public static void main(String[] args) {
        // 自动类型转换
        byte a = 19;
        int b = 19 + a;
        // 这个函数参数是double，传a进入，会自动转换成double
        print(a);

        // 强制类型转换
        byte c = (byte) 1200;
        System.out.println("\n");
        System.out.println(c);
    }

    public static void print(double d) {
        // 自动类型转换
        System.out.print(d);
    }
}
