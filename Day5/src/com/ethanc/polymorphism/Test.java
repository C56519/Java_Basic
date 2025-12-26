package com.ethanc.polymorphism;

// 多态
// 对象多态、行为多态
// 前提：1 必须有继承/实现关系
//      2 存在父类引用子类对象 People p1 = new Student() 即父类p1变量指向子类对象
//      3 要存在方法重写（抽象方法抽象类就是为了增强这一前提）
// 格式：父类 对象名 = new 子类();
// 这里明显与普通的对象初始化不同，普通的是: 当前类 对象名 = new 当前类();
// 引入多态的概念
// 1 在多态形式下，右边是解耦的，更利于扩展、维护和代码复用。People p1 = new Student()
// 2 定义方法时，使用父类类型的形参，可以接收一切子类对象，扩展性更强、更便利
// 3 多态的局限性：多态下不能使用子类独有的功能(也就是父类中的重名也就是重写的方法才可以使用，子类中独有的不行)，需要强转

// 类型转换：
// 1 自动类型转换：父类 变量名 = new 子类()   子类类型给到父类类型变量
// 2 强制类型转换：子类 变量名 = (子类) 父类变量;
//      强转注意事项：
//                  1 只要是两者存在继承/实现关系，那么就可以在编译阶段进行强制类型转换转化，编译阶段不会报错
//                  2 但当运行阶段，一旦发现对象的真实类型与强转后的类型不一致，就会报错ClassCastException
//                  3 一般强转前用 instanceof 关键字来做一步类型判断
public class Test {
    public static void main(String[] args) {
        // 父类 对象名 = new 子类();
        // 也就是a1虽然是父类Animals类数据类型，但是实际指向子类 Tiger
        Animals a1 = new Tiger();
        a1.run();   // 编译看左边，运行看右边。也就是编译看Animals里的，运行看Tiger里的，所以父类中必须要有
        System.out.println(a1.name);    // 多态针对对象和方法，但不针对成员变量，对于成员变量，编译、运行都看左边Animals。

        Animals a2 = new Turtle();
        a2.run();

        startRun(a1);
        startRun(a2);

        // 如果想要调用子类独特的方法，那么就需要强转
        Tiger t1 = (Tiger) a1;
        t1.yell();

        // ClassCastException与instanceof
        // 下面代码，a2虽然为Animals类型，但内部实际指向乌龟，强转为老虎，编译没问题，但运行会报错
        // Tiger t2 = (Tiger) a2;
        // 所以需要用instanceof关键字做判断
        if (a2 instanceof Turtle) {
            Turtle t2 = (Turtle) a2;
        }
        // 如果我要在下面公用逻辑中，加一条各自独特的逻辑，那么需要封装一个方法transformSelf
    }
    // 下面逻辑，乌龟和老虎，都一样，如果不用多态，那么因为传入的参数类型不同，同一逻辑需要写两遍方法
    // public static void startRun(Tiger a)、public static void startRun(Turtle a)
    // 现只需要传入参数为Animals a，也就是父类类型的变量作为参数，可以接收所有子类对象，从而共用一个逻辑处理
    public static void startRun(Animals a) {
        System.out.println("动物赛跑比赛开始：");
        a.run();

        transformSelf(a);
    }

    public static void transformSelf(Animals a) {
        if (a instanceof Tiger) {
            Tiger t1 = (Tiger) a;
            t1.yell();
        } else if (a instanceof Turtle) {
            Turtle t2 = (Turtle) a;
            t2.run();
        }
    }
}
