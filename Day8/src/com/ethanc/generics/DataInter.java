package com.ethanc.generics;

// 假设链接了数据库，定义这个泛型接口来增删改查
public interface DataInter<E> {
    void add(E e);
    void delete(E e);
    void update(E e);
    E query(int id);
}
