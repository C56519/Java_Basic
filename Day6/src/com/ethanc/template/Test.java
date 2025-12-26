package com.ethanc.template;

// 设计模式：模板方法设计模式
// 代码复用，将重复代码抽出来，写成模板。并使用抽象方法技术，强制子类在继承该模板复用功能后，重写自有功能
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.selfIntro();
        Teacher teacher = new Teacher();
        teacher.selfIntro();
    }
}
