package com.ethanc.lambdademo;
import java.util.Arrays;
import java.util.Comparator;

// Lamda表达式的进一步简化
// 规则：
// 1. 参数类型全部可以省略不写 (a1, a1) -> {...}
// 2. 如果只有一个参数，参数类型省略的同时“()”也可以省略，但多个参数不能省略“()”     a -> {...}
// 3. 如果Lambda表达式中只有一行代码，大括号可以不写，同时要省略分号“;”。如果这行代码是return语句，也必须去掉return。
public class LambdaDemo2 {
    public static void main(String[] args) {
        // 以匿名内部类的一个做过的案例来讲解
        Student[] stl = new Student[5];
        stl[0] = new Student("张三", 20);
        stl[1] = new Student("李四", 19);
        stl[2] = new Student("王五", 19);
        stl[3] = new Student("赵六", 24);
        stl[4] = new Student("孙七", 23);

        // 原来根据年龄排序逻辑
        // ctri + 点击 Comparator 看源码直接看到了@FunctionalInterface，说明是个函数式接口，可以直接用Lambda表达式简化
        Arrays.sort(stl, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        // 用Lambda表达式
        Arrays.sort(stl, (Student o1, Student o2) -> {
            return o1.getAge() - o2.getAge();
        });
        // 继续简化：
        // 1. 直接省略参数类型
        // 2. 由于是两个参数，所以不能省略参数的括号   (x) -> {}  简化为 x -> {}
        // 3. 函数体中，因为只包含一条语句，所以直接省略花括号和分号。同时，这一行语句是return语句，所以可以省略return
        Arrays.sort(stl, (o1, o2) -> o1.getAge() - o2.getAge());
        printAllStudents(stl);
    }

    public static void printAllStudents (Student[] stl) {
        for (int i = 0; i < stl.length; i++) {
            System.out.println(stl[i].toString());
        }
    }
}
