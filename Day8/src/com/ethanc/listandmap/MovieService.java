package com.ethanc.listandmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class MovieService {
    // 1 准备一个集合，来存储所有电影数据
    private static List<Movie> mList = new ArrayList<Movie>();

    // 2 启动
    public static void start() {
        while (true) {
            // 显示菜单
            System.out.println("----------电影管理系统----------");
            System.out.println("1. 添加电影");
            System.out.println("2. 显示所有电影");
            System.out.println("3. 删除电影");
            System.out.println("4. 修改电影");
            System.out.println("5. 查询电影");
            System.out.println("6. 封杀某演员");
            System.out.println("7. 退出");
            System.out.println("请选择：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            // 总分支逻辑
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    showAllMovie();
                    break;
                case 3:
                    deleteMovie();
                    break;
                case 4:
                    updateMovie();
                    break;
                case 5:
                    queryMovie();
                    break;
                case 6:
                    killActor();
                    break;
                case 7:
                    System.out.println("退出成功");
                    return;
                default:
                    System.out.println("请输入正确序号");
            }
        }
    }

    // 添加电影
    private static void addMovie() {
        // 显示和记录输入
        System.out.println("----------添加电影----------");
        System.out.println("请输入电影名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入主演：");
        String actors = sc.next();
        System.out.println("请输入评分：");
        double score = sc.nextDouble();
        System.out.println("请输入价格：");
        double price = sc.nextDouble();
        // 创建电影对象
        Movie m = new Movie(name, actors, score, price);
        mList.add(m);
        System.out.println("添加成功");
    }

    // 显示所有电影
    private static void showAllMovie() {
        System.out.println("----------所有电影----------");
        if (mList.size() == 0) {
            System.out.println("请添加电影后再操作");
            return;
        }
        // 遍历集合
        for (Movie m : mList) {
            // 打印m的详细信息
            System.out.println("电影名称：" + m.getName() + " | 主演：" + m.getActors() + " | 评分：" + m.getScore() + " | 价格：" + m.getPrice());
            System.out.println();
        }
    }

    // 删除电影
    private static void deleteMovie() {
        System.out.println("----------删除电影----------");
        System.out.println("请输入要删除的电影名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Iterator it = mList.iterator();
        while (it.hasNext()) {
            Movie m = (Movie)it.next();
            if (name.equals(m.getName())) {
                it.remove();
                System.out.println("删除成功");
                return;
            }
        }
    }

    // 修改电影
    private static void updateMovie() {
        System.out.println("----------修改电影----------");
        System.out.println("请输入要修改的电影名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Iterator it = mList.iterator();
        while (it.hasNext()) {
            Movie m = (Movie)it.next();
            if (name.equals(m.getName())) {
                System.out.println("请输入新的电影名称：");
                String newName = sc.next();
                System.out.println("请输入新的主演：");
                String newActors = sc.next();
                System.out.println("请输入新的评分：");
                double newScore = sc.nextDouble();
                System.out.println("请输入新的价格：");
                double newPrice = sc.nextDouble();
                m.setName(newName);
                m.setActors(newActors);
                m.setScore(newScore);
                m.setPrice(newPrice);
                System.out.println("修改成功");
                break;
            }
        }
        System.out.println("没有此电影");
    }

    // 查询电影
    private static void queryMovie() {
        System.out.println("----------查询电影----------");
        System.out.println("请输入要查询的电影名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for (Movie m : mList) {
            if (name.equals(m.getName())) {
                System.out.println("电影名称：" + m.getName() + " | 主演：" + m.getActors() + " | 评分：" + m.getScore() + " | 价格：" + m.getPrice());
                return;
            }
        }
        System.out.println("没有此电影");
    }

    // 封杀某演员参演的所有电影
    private static void killActor() {
        System.out.println("----------封杀某演员参演的所有电影----------");
        System.out.println("请输入要封杀的演员：");
        Scanner sc = new Scanner(System.in);
        String actor = sc.next();
        // 删除包含指定演员成员变量的所有电影
        Iterator it = mList.iterator();
        while (it.hasNext()) {
            Movie m = (Movie)it.next();
            if (m.getActors().contains(actor)) {
                it.remove();
            }
        }
        System.out.println("封杀成功");
    }
}
