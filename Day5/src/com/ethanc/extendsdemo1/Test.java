package com.ethanc.extendsdemo1;

// 继承
// Java中使用 extends 关键字实现继承
// 可以让一个类和另一个类建立起父子关系：public class 子类 extends 父类{...}
// 1 注意：
// 1.1 子类继承父类所有的非私有成员变量和方法
// 1.2 子类的对象其实是由子类和父类多张设计图共同完成，所以子类对象是完整的
// 为什么使用继承？ 多个对象之间可能存在很多重复使用的属性，使用继承，提高了代码的复用性

// 2 特点：
// 单继承：只能有一个父类。也就是只有一个爸爸
// 多层继承：虽然单继承，但可以嵌套继承。可以有爷爷、祖爷
// 祖宗类：所有类的根类，为Object类，所以默认继承Object类中的所有成员变量和方法
// 就近原则：优先访问自己类，自己类中没有才会访问父类找，找不到继续往上找（更细一点比如方法调用，优先考虑参数、方法内变量 -> 本类成员变量 -> 父类 -> 爷爷类）
//          如果父类和子类有同名成员变量、方法，实在想用父类的那个，用关键字super。
//          方法重写：如果是同名且参数列表一样的方法，覆盖了父类方法，叫做方法重写。(详见Teacher类)
//          如：super.name指向父类    this.name指向本类成员变量   调方法也一样

// 3 构造器：
// 在继承关系中，子类所有构造器都必须先调用父类构造器，再执行自己的构造器
// 如果子类不写，默认调用父类的无参构造器
// 如果子类写了无参构造器，则父类中也必须有无参构造器
// 如果子类写了有参构造器，则父类中必须有有参构造器
// this() 和 super() 详见 Assistant类

public class Test {
    public static void main(String[] args) {
        // 如：Teacher讲师类与Assistant助教类都继承了People类
        // People父类，Teacher、Assistant子类
        Teacher t = new Teacher();
        // 子类可直接继承父类公开的成员方法和变量
        t.setName("Tom");
        t.setAge(25);
        t.setSex("男");
        t.setSkill("Java, Python, Tensorflow, Deep learning");

        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getSex());
        System.out.println(t.getSkill());
    }
}
