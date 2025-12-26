package com.ethanc.methodreference;
import java.util.Arrays;
import java.util.Comparator;

// 方法引用技术
// 进一步简化Lambda表达式
// 1. 静态方法引用
//      格式：类名::静态方法名
//      使用场景：如果某个Lambda表达式里只是调用了一个静态方法，并且 “->” 符号前后参数的形式一致，就可以使用静态方法引用
// 2. 实例方法引用
//      格式：实例名::实例方法
//      使用场景：如果某个Lambda表达式里只是通过对象名称调用一个实例方法，并且 “->” 符号前后参数的形式一致，就可以使用实例方法引用
public class MethodR1 {
    public static void main(String[] args) {
        Student[] stl = new Student[5];
        stl[0] = new Student("张三", 20, 175);
        stl[1] = new Student("李四", 19, 183);
        stl[2] = new Student("王五", 19, 175);
        stl[3] = new Student("赵六", 24, 162);
        stl[4] = new Student("孙七", 23, 160);

        Arrays.sort(stl, (o1, o2) -> o1.getAge() - o2.getAge());

        // 静态方法引用
        // compareByAge是静态方法，并且上边显示 “->”，左边参数为o1,o2，右边的compareByAge参数也是o1,o2，所以可以进行静态方法引用
        Arrays.sort(stl, Student::compareByAge);

        // 实例方法引用
        // 先创建一个对象，然后通过对象调用实例的成员方法
        Student t = new Student();
        Arrays.sort(stl, ((o1, o2) -> t.compareByHeight(o1, o2)));
        // 使用实例方法引用简化
        Arrays.sort(stl, t::compareByHeight);

        printAllStudents(stl);
    }

    public static void printAllStudents (Student[] stl) {
        for (int i = 0; i < stl.length; i++) {
            System.out.println(stl[i].toString());
        }
    }
}
