package com.ethanc.generics;

// 之前用多态，现在直接用泛型，往泛型接口中传入Student类型，泛型接口中的泛型会被设置为Student类型
public class StudentImpl implements DataInter<Student>{
    @Override
    public void add(Student stu) {}
    @Override
    public void delete(Student stu) {}

    @Override
    public void update(Student stu) {}

    @Override
    public Student query(int id) {
        return null;
    }
}
