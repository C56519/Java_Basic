package com.ethanc.enumeration;

// 枚举类
// 定义：是一种特殊的类，主要用于做信息的分类和标志
// 写法：
// 修饰符 enum 枚举类名 {
//   对象1, 对象2, 对象3;
//  }
// 特点：1 枚举类中的第一行，只能罗列一个个名称，并用逗号隔开，本质上是一个个常量，并且每个常量代表枚举类的一个对象
//      2 枚举类都是最终类，不能被继承，但枚举类都继承自java.lang.Enum类
//      3 枚举类的构造器都是私有的(写不写都只能是私有)，所以枚举类对外无法创造对象
public class Test {
    // 控制车的上下左右
    // 当然这个逻辑也可以用常量来做，不用枚举类，四个方向常量
    public static void main(String[] args) {
        // 直接传入枚举类对象
        // 使用枚举类内的对象用点方法
        move(Direction.UP);
    }
    public static void move(Direction direction) {
        switch (direction) {
            case direction.UP:
                System.out.println("向上");
                break;
            // 因为switch表达式传入的就是枚举类对象，所以可以省略点方法，直接接枚举类对象
            case DOWN:
                System.out.println("向下");
                break;
            case LEFT:
                System.out.println("向左");
                break;
            case RIGHT:
                System.out.println("向右");
                break;
        }

    }
}
