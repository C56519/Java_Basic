package com.ethanc.obj2javabean;
import java.util.Scanner;

public class MovieOperator {
    // 1 成员变量，将来要操作的对象的数据，这里是传入了对象数组
    private Movie[] movies;

    // 2 通过有参构造方法传入对象数组来初始化成员变量，拿到数据
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    // 3 业务逻辑
    // 打印每个电影的所有信息
    public void printAllInfo() {
        System.out.println("所有电影信息：");
        for (int i = 0; i < movies.length; i++) {
            String name = movies[i].getName();
            double score = movies[i].getScore();

            System.out.print("名称：" + name + "\t" + "豆瓣评分：" + score);
            System.out.println();
        }
    }
    // 用户输入ID查询电影的所有信息
    public void queryById() {
        System.out.println("请输入要查询的电影ID：");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (int i = 0; i < movies.length; i++) {
            int tempId = movies[i].getId();
            if (tempId ==  id) {
                System.out.println("名称：" + movies[i].getName() + "\t" + "豆瓣评分：" + movies[i].getScore() + "\t" + "主演：" + movies[i].getActor());
                return;
            }
        }
        System.out.println("没有查询到该电影");
    }
}
