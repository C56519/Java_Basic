package com.ethanc.template;

public abstract class Person {
    // 模板设计模式
    // 将自定义部分抽离出来，封装到一个方法中，并规定为抽象方法，强制子类实现该部分功能的自定义。
    // 该模板方法，建议使用final修饰，以防止子类重写该模板
    public final void selfIntro() {
        System.out.println("I am from Cardiff University.");
        System.out.println("I am living in Welsh");
        System.out.println("My institution is the School of Computer Science");
        // 自定义部分
        mainBody();
        System.out.println();
    }
    // 自定义部分方法，抽象方法
    public abstract void mainBody();
}
