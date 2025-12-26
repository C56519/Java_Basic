package com.ethanc.generics;

// 2. 泛型接口
// 修饰符 interface 接口名<类型变量, 类型变量, ...> {}
public class Generics2 {
    public static void main(String[] args) {
        // 目标：弄懂泛型接口的基本作用
        // 需求：项目需要对学生数据、老师数据都进行增删改查操作

        // 只是模拟，实际没写逻辑，只为了演示泛型接口
        StudentImpl stu = new StudentImpl();
        stu.add(new Student());
        stu.delete(new Student());
    }
}
