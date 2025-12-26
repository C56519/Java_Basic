package com.ethanc.interfacedemo;

// 实现类
// 一般命名以Impl做后缀
// 实现输出所有学生的信息，输出平均分的功能
public class StudentImple1 implements StudentInter {
    private Student[] stlist;
    // 构造器
    public StudentImple1() {}
    public StudentImple1(Student[] stlist) {
        this.stlist = stlist;
    }

    // 实现接口方法
    @Override
    public void printAllInfo() {
        System.out.println("所有学生的信息如下：");
        for (int i = 0; i < stlist.length; i++) {
            Student st = stlist[i];
            System.out.println("姓名：" + st.getName());
            System.out.println("性别：" + st.getSex());
            System.out.println("分数：" + st.getScore());
            System.out.println();
        }
    }
    @Override
    public void getAvgScore() {
        double sum = 0.0, avg = 0.0;
        for (int i = 0; i < stlist.length; i++) {
            sum += stlist[i].getScore();
        }
        avg = sum / stlist.length;
        System.out.println("平均分是：" + avg);
    }
}
