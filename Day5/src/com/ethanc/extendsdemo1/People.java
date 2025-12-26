package com.ethanc.extendsdemo1;

// 父类
public class People {
    // 私有成员变量，做了封装，但是公开了getter setter方法，所以子类可以通过公开方法来访问、修改这些成员变量的值
    private String name;
    private int age;
    private String sex;

    public People() {}

    public People(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // 演示方法重写
    public void showIncome(int income) {
        System.out.println("收入：" + income);
    }
}
