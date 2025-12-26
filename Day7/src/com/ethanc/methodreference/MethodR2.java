package com.ethanc.methodreference;
import java.util.Arrays;
import java.util.Comparator;

// 方法引用技术
// 3. 特定类的方法引用
// 格式：特定类的名称::方法
// 使用场景：如果某个Lambda表达式里只是调用一个特定类型的实例方法，并且前面参数列表中的第一个参数是作为方法的主调，
//          后面的所有参数都是作为该实例方法的入参的，则此时就可以使用特定类型的方法引用。
// 4. 构造器方法引用
// 格式：类名::new
// 使用场景：如果某个Lambda表达式里只是在创建对象，并且 “->” 前后参数情况一致，就可使用构造器引用
public class MethodR2 {
    public static void main(String[] args) {
        // 一、特定类的方法引用
        // 创建一个字符串数组，内含8个英文人名字符串
        String[] names = {"Jack", "Tom", "rose", "Jim", "Mike", "mary", "Andy", "Ethan"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        // 忽略首字母大小排序
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // String字符串方法：s1.compareToIgnoreCase(s2)
                // 作用：将字符串s1与s2比较，忽略大小写，返回结果
                // 返回值：当前字符串首字母 > 参数字符串 返回正整数
                //        当前字符串首字母 < 参数字符串 返回负整数
                //        当前字符串首字母 = 参数字符串 返回0
                return o1.compareToIgnoreCase(o2);
            }
        });
        // 使用方法引用简写
        // 1. 表达式只调用了一个o1.compareToIgnoreCase(o2)，这是字符串类型的方法，属于单一特定类型
        // 2. o1正好是第一个参数，并且是特定类型的方法compareToIgnoreCase的主调
        Arrays.sort(names, String::compareToIgnoreCase);


        // 二、构造器方法引用、
        // 需求：输入一个车的名字，然后得到该车的对象

        // 先使用匿名内部类来演示传统做法
        CarFactory cf = new CarFactory() {
            @Override
            public Car getCar(String name) {
                return new Car(name);
            }
        };

        // Lambda表达式
        CarFactory cf2 = name -> new Car(name);

        // 使用方法引用简写
        // new Car(name) 表达式功能只是在创建对象
        // -> 前后参数都是 name
        CarFactory cf1 = Car::new;

        Car c1 = cf1.getCar("保时捷");
        System.out.println(c1.getName());
    }
}

interface CarFactory {
    // 返回值为 Car 类型对象
    Car getCar(String name);
}
class Car {
    private String name;

    public Car() {
    }
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
