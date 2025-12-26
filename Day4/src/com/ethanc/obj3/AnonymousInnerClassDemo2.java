package com.ethanc.obj3;

import java.util.Arrays;
import java.util.Comparator;

// 匿名内部类的练习

// 需求：按照身高进行排序
public class AnonymousInnerClassDemo2 {
    public static void main(String[] args) {
        Student[] stl = new Student[5];
        stl[0] = new Student("张三", 18, 1.75);
        stl[1] = new Student("李四", 19, 1.83);
        stl[2] = new Student("王五", 20, 1.91);
        stl[3] = new Student("赵六", 21, 1.62);
        stl[4] = new Student("孙七", 22, 1.62);

        // 使用Arrays.sort()方法对对象数组进行排序
        //      参数1：需要排序的数组
        //      参数2：比较器对象（一般可省略，按照自动排序，但这里要用我们指定的逻辑排序）
        // 默认升序
        // 参数二使用了匿名内部类充当比较器对象，然后重写了compare()方法以实现自定义的排序逻辑
        Arrays.sort(stl, new Comparator<Student>() {
            @Override
            // compare()方法：用来告诉比较器，两个对象谁大谁小
            // 参数：o1，o2：比较的两个对象（会自动从数组中拿）
            // 返回值：如果是正整数，则告诉比较器 o1大，返回负数则o2大，返回0则o1等于o2
            public int compare(Student o1, Student o2) {
                double h1 = o1.getHeight();
                double h2 = o2.getHeight();
                if (h1 > h2) {
                    return 1;
                } else if (h1 < h2) {
                    return -1;
                } else {
                    return 0;
                }
                // 以上逻辑可以简写为：return (int)(h1 - h2); 因为compare()方法返回值是int类型，但身高是double类型，但这样会有误差，不建议
                // 同理：如果想得到降序只需要 return (int)(h2 - h1)
            }
        });
        // 对象数组按照身高进行排序
        printAllStudents(stl);
    }
    public static void printAllStudents (Student[] stl) {
        for (int i = 0; i < stl.length; i++) {
            System.out.println(stl[i].toString());
        }
    }
}
