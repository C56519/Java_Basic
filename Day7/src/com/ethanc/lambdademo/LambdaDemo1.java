package com.ethanc.lambdademo;

// 函数式编程：
// 定义：是一种"编程范式"，主要思想是把运算过程尽量写成一系列嵌套的函数调用。
// Java 中的函数一般用Lambda表达式来写
// 解决了什么问题：使用Lambda表达式可以替代 函数式接口 的匿名内部类对象，以简化代码，增强可读性
// 注意：Lambda表达式只能简化 函数式接口 的匿名内部类对象，别的不行

// Lambda表达式
// 格式：(被重写方法的参数列表) -> {被重写方法的方法体代码}
public class LambdaDemo1 {
    public static void main(String[] args) {
        // 原来代码，使用匿名内部类
        Animal a1 = new Animal() {
            @Override
            public void eat() {
                System.out.println("老虎吃肉");
            }
        };
        // 使用Lambda表达式简化
        // Animal a2 = () -> { System.out.println("老虎吃肉") };
        // 这里会报错，为什么？因为Lambda表达式只能简化 函数式接口 的匿名内部类对象，别的不行
        // 所以，因为Animal类不是函数式接口，所以不能用Lambda表达式简化
        // 正确示范如下：

        AnimalInter a2 = () -> {
            System.out.println("老虎吃肉");
        };
        a2.eat();
        // 为什么能省略简化？    因为使用上下文推断技术，首先根据上文也就是左边，知道AnimalInter是个函数式接口，
        // 然后根据下文，也就是右边，知道System.out.println("老虎吃肉")是一段重写的代码，所以可以推断出真正代码，也就是上边未简化的完整代码
    }

}

abstract class Animal {
    public abstract void eat();
}

// 函数式接口：
// 有且仅有一个抽象方法的接口
// 使用@FunctionalInterface 注解，可以检查该函数式接口是否规范
@FunctionalInterface
interface AnimalInter {
    void eat();
}
