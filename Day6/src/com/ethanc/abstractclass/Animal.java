package com.ethanc.abstractclass;

public abstract class Animal {
    private String name;

    // 虽然抽象类不能创建对象，但可以有构造方法，供子类创造实例时使用
    Animal() {}
    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 定义一个抽象方法：
    // 1. 所在的Animal类也要变为抽象类，否则编译出错
    // 2. 声明该抽象类的作用是强制规定其子类必须重写该抽象方法，否则也要声明为抽象类
    public abstract void yell();
}
