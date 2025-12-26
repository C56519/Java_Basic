package com.ethanc.obj2javabean;

// javabean模式
// 属于一种代码分层解耦模式，将数据和逻辑分离开
// 对象类只写数据与get set，成为实体类。
// 而其他对类中的数据逻辑操作写到一个单独的类中
public class Test {
    public static void main(String[] args) {
        // 1 创建一个包含对象的数组
        // 数据类型[] 数组名 = new 数据类型[数组长度];
        // 这里类名可直接作为数据类型来创建一个包含六个对象的数组
        Movie[] movies = new Movie[6];
        // movies: [null, null, null, null, null, null]

        // 2 实例化不同的对象
        movies[0] = new Movie(0, "让子弹飞", 9.0, "姜文");
        movies[1] = new Movie(1, "流浪地球", 8.5, "吴京");
        movies[2] = new Movie(2, "南京照相馆", 8.8, "王传君");
        movies[3] = new Movie(3, "功夫", 8.9, "周星驰");
        movies[4] = new Movie(4, "疯狂的石头", 8.6, "郭涛");
        movies[5] = new Movie(5, "英雄本色", 8.6, "周润发");

        // 3 创建电影操作对象，专门负责电影数据的业务逻辑操作
        MovieOperator mp = new MovieOperator(movies);   // 需要传入要处理的对象数组数据
        mp.printAllInfo();
        mp.queryById();
    }
}
