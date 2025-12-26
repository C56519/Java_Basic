package com.ethanc.obj1;

// 对象
// 学习关键字：static静态变量和方法，成员变量和成员方法，public、private等四种权限修饰符，构造器方法
// 实例化对象，修改、访问对象成员变量，调用成员方法
public class Ob1 {
    public static void main(String[] args) {
        // 实例化对象
        Student p1 = new Student(); // 调用无参构造器
        // 配置对象成员变量值
        p1.name = "Jack";   // 因为name成员变量未作封装，所以直接可用点方法访问、赋值
        p1.setHeight(1.77); // 因为height成员变量做了封装，所以只能通过setter方法赋值
        p1.setAge(18);

        System.out.println(p1.getAge());
        p1.getInfo();

        // 调用有参构造器实例化对象，直接配置各成员变量的值
        Student p2 = new Student("Tom", 1.68, 17);
        p2.getInfo();

        // 打印Student类共创建了几个对象
        // 调用时用类名调用，当然也可通过对象名调用，但不推荐
        System.out.println(Student.getCount());
        System.out.println(p1.getCount());  // 不推荐
    }
}