package com.ethanc.obj3;

// 内部类
// 一个类定义在另一个类内部，这个类就是内部类
// 分类：成员内部类、静态内部类、局部内部类、匿名内部类
// 1. 成员内部类
//      格式：直接在外部类中以类的形式定义。  创建对象格式：外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
//      很像之前的成员变量、方法，是在成员对象层面
// 2. 静态内部类
//      格式：直接在外部类中以类的形式定义，并使用static 修饰符修饰。  创建对象格式：外部类名.内部类名 对象名 = new 外部类名.内部类名();
//      在类的层面，而非成员实例对象层面
// 3. 局部内部类
//      格式：定义在方法内部
// 4. 匿名内部类
//      见
public class InnerClass {
    public static void main(String[] args) {
        // 1 成员内部类
        // 创建对象
        Outer1.Inner1 ic1 = new Outer1().new Inner1();
        // 继承
        // class A extends Outer1.Inner1 {}
        // 访问外部类成员的特点
        // a. 可直接访问外部类的静态成员、实例成员
        // b. 可以直接拿到外部类对象：外部类名.this

        // 2 静态内部类
        // 创建对象
        Outer2.Inner2 ic2 = new Outer2.Inner2();

        // 3 局部内部类
        // 直接在方法内部定义一个类，几乎不用
        class Inner3 {
        }
        abstract class Inner4 {
        }
        interface Inner5 {}
    }
}

// 1 成员内部类
class Outer1 {
    private int num = 10;
    public static int num2 = 20;

    // 成员内部类
    class Inner1 {
        // 内部跟类一样，可以自定义构造器、成员变量、方法
        public void show() {
            System.out.println("成员内部类");
            // 直接访问外部类静态、实例成员
            System.out.println(num);
            System.out.println(num2);
            // 直接拿到外部类对象
            int n = Outer1.this.num;
        }
    }
}

// 2 静态内部类
class Outer2 {
    public static int num = 10;
    private int num2 = 20;

    // 静态内部类
    public static class Inner2 {
        // 内部跟类一样，可以自定义构造器、成员变量、方法
        public void show() {
            // 静态内部类只能访问外部类的静态成员
            System.out.println(num);
            // 静态内部类不能访问外部类的实例成员
            // System.out.println(num2);
        }
    }
}

// 3 局部内部类
