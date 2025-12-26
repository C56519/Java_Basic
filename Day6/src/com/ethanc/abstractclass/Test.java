package com.ethanc.abstractclass;

// 抽象类和抽象方法
// 使用abstract关键字修饰的类和方法
// 特点：1 抽象类不能创建对象，仅作为一种特殊的父类，让子类继承，
//      2 而子类一但继承抽象类，必须重写抽象类中所有的抽象方法，否则这个子类也必须定义为抽象类
//      3 抽象类下可以不包含抽象方法，但一旦定义了一个抽象方法，那么这个类必须声明为抽象类
// 应用：抽象类、抽象方法通常能更好的支持多态，也就是规定内部的抽象方法子类必须自己重写

public class Test {
    public static void main(String[] args) {
        // Animal animal = new Animal();    // 抽象类无法创建对象
        // 多态
        Animal tiger = new Tiger("老虎");
        animalYell(tiger);
        Animal cat = new Cat();
        animalYell(cat);


    }
    public static void animalYell(Animal a){
        a.yell();
    }
}
