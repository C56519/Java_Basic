package com.ethanc.methodreference;

public class Student {
    private String name;
    private int age;
    private double height;

    public Student() {
    }
    public Student(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    // 静态方法引用
    // 将比较器中的函数抽出来，定于成一个静态方法
    public static int compareByAge(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }

    // 实例方法引用
    // 创建一个实例方法
    public int compareByHeight(Student o1, Student o2) {
        // Double.compare(double a， double b)
        // 功能：比较两个double值的大小
        // 返回值：如果a > b，则返回1；如果a < b，则返回-1；如果a == b，则返回0
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}

