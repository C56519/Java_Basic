package com.ethanc.interfacedemo;
import java.util.Arrays;

// 实现类
// 实现输出所有学生的信息，并给出男女数量
// 去除最大值、最小值，再输出平均分的功能
public class StudentImple2 implements StudentInter {
    private Student[] stlist;
    // 构造器
    public StudentImple2() {}
    public StudentImple2(Student[] stlist) {
        this.stlist = stlist;
    }

    // 实现接口方法
    @Override
    // 输出所有学生的信息
    public void printAllInfo() {
        int stNum = 0;
        int maleNum = 0;

        System.out.println("所有学生的信息如下：");
        for (int i = 0; i < stlist.length; i++) {
            Student st = stlist[i];
            System.out.println("姓名：" + st.getName());
            System.out.println("性别：" + st.getSex());
            System.out.println("分数：" + st.getScore());
            System.out.println();
            stNum++;
            if (st.getSex().equals("男")) {
                maleNum++;
            }
        }
        System.out.println("男学生数量是：" + maleNum);
        System.out.println("女学生数量是：" + (stNum - maleNum));
    }
    @Override
    // 输出平均分
    public void getAvgScore() {
        // 获取成绩，组成数组，然后排序，找到最小值最大值
        double[] score = new double[stlist.length];
        double sum = 0.0, avg = 0.0;

        for (int i = 0; i < stlist.length; i++) {
            score[i] = stlist[i].getScore();
        }
        Arrays.sort(score);
        // System.out.println(Arrays.toString(score));
        // 去掉最高分、最低分再计算平均值
        for (int i = 1; i < score.length - 1; i++) {
            sum += score[i];
        }
        avg = sum / (stlist.length - 2);
        System.out.println("平均分是：" + avg);
    }
}
