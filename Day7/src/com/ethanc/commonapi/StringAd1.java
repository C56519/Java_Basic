package com.ethanc.commonapi;

// String字符串API
// 1. 创建一个字符串对象：两种方法
// 2. 常用API
//      .length()
//      .charAt(int index)
//      .toCharArray()
//      .equals(String)
//      .equalsIgnoreCase(String)
//      .substring(int startIndex, int endIndex)
//      .replace(char oldChar, char newChar)
//      .contains(String str)
//      .startsWith(String str)
//      .endsWith(String str)
//      .split(String regex)
//      .toUpperCase()
//      .toLowerCase()
public class StringAd1 {
    public static void main(String[] args) {
        // 1 创建字符串的两种方法
        // 方法一（推荐）：直接写，就可以创建字符串对象
        String s = "test1";
        System.out.println(s);
        String s1 = ""; // 空字符串

        // 方法二：调用String类的构造器初始化字符串对象
        // 创建一个字符串对象，并初始化字符串对象
        String s2 = new String(); // 空字符串
        String s3 = new String("test2");

        // 根据字符数组内容，来创建字符串对象
        char[] ch = {'t', 'e', 's', 't', '3'};
        String s4 = new String(ch); // 将字符数组转换成字符串

        // 根据字节数组的内容，来创建字符串对象
        byte[] b = {116, 101, 115, 116, 52};    // ASCII码
        String s5 = new String(b);  // 将字节数组转换成字符串

        // 两种方法区别：
        // 只要是以“...”方式写出的字符串对象，会存储到堆里面的字符串常量池中，且相同内容的字符串只存储一份，多个变量共享这个字符串对象，为了节约内存而设计
        // 通过new方式创建字符串对象，每new一次都会产生一个新的对象放在堆内存中。
        String t1 = "aabbcc";
        String t2 = "aabbcc";
        System.out.println(t1 == t2);   // true

        String t3 = new String("abc");
        String t4 = new String("abc");
        System.out.println(t3 == t4);   // false


        // 2 常用API
        String s6 = "hello world";
        String s7 = "hello world";
        // .length()
        // 获取字符串长度（也就是字符个数）
        // 返回值：int 字符串长度
        System.out.println(s6.length());

        // .charAt(int index)
        // 获取指定索引位置的字符
        // 返回值：char
        System.out.println(s6.charAt(1));

        // .toCharArray()
        // 将字符串转换成字符数组
        // 返回值：一个字符数组
        System.out.println(s6.toCharArray());

        // .equals(String)
        // 判断字符串内容是否相同
        // 返回值：boolean
        System.out.println(s6.equals(s7));

        // .equalsIgnoreCase(String)
        // 忽略大小写判断两个字符串内容是否相同
        // 返回值：boolean
        System.out.println(s6.equalsIgnoreCase(s7));

        //.substring(int startIndex)
        // 获取从指定索引位置开始，到字符串末尾的字符串
        // 返回值：String
        System.out.println(s6.substring(1));

        // .substring(int startIndex, int endIndex)
        // 获取从指定索引位置开始，到指定索引位置结束的字符串，左开右闭
        // 返回值：String
        System.out.println(s6.substring(1, 3));     // [1, 3)

        // .replace(char oldChar, char newChar)
        // 替换字符串中指定的字符（所有都替换），返回新字符串
        // 返回值：String
        String t5 = s6.replace('h', 'H');
        System.out.println(t5);

        // .contains(String str)
        // 判断字符串中是否包含指定的字符串
        // 返回值：boolean
        System.out.println(s6.contains("ll"));

        // .startsWith(String str) 和 .endsWith(String str)
        // 判断字符串是否以指定的字符串开头
        // 返回值：boolean
        System.out.println(s6.startsWith("he"));
        System.out.println(s6.endsWith("d"));

        // .split(String regex)
        // 按照指定的格式，将字符串进行切割，切割成字符串数组
        // 返回值：String[]
        System.out.println(s6.split(" "));

        // .toUpperCase() 和 .toLowerCase()
        // 将字符串中的字符全部转换成大写或小写
        // 返回值：String
        System.out.println(s6.toUpperCase());
        System.out.println(s6.toLowerCase());
    }
}
