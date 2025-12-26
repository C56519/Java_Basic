package com.ethanc.set;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private double score;

    public Student() {
    }
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", score=" + score +'\'' +
                '}' + "\n";
    }

    // 重写equals()和hashCode()
    // 右键自动生成的代码

    @Override
    // 作用是只要两个对象的内容一样，就返回true
    public boolean equals(Object o) {
        // 参数：o 为要与之比较的对象
        // 1 如果是自己和自己比，直接返回 true
        if (this == o) return true;
        // 2 如果o为空，或者o不是Student类型，则返回false
        if (o == null || this.getClass() != o.getClass()) return false;
        // 3 比较两个对象内容是否一样
        Student student = (Student) o;
        return age == student.age && Double.compare(score, student.score) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        // 这里不用管Objects.hash()原理，只需要知道我们传到这个函数里的参数，如果两个对象内容一样，那么也就是传入的参数都相同
        // 返回值也会相同，也就是计算出了相同的哈希值
        return Objects.hash(name, age, score);
    }
}
