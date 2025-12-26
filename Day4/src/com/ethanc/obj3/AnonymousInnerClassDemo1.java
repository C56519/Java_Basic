package com.ethanc.obj3;

// 匿名内部类
// 无需声明类的名称直接定义一个类      （其实编译时会自动创建一个完整标准的有名类：外部类名$编号.class）
// 本质：是一个子类，并会立即创建出一个子类对象
// 格式：new 父类或接口名(参数列表) { 方法体(一般为方法重写) }
// 作用：可以更方便的创建子类对象，也能简化代码
// 使用场景：
//      1. 通常用来直接创建一个子类对象，传给函数当参数来用
//      2. 开发中，不是我们主动写匿名内部类，而是当我们调用库函数、别人的逻辑方法时，别人可以让我们写一个匿名内部类，我们才用。
//              比如：他们的参数正好是个抽象类或接口型，并且需要重写来让使用者完成自己的逻辑，那么告诉你可以使用匿名内部类，那就用，可遇不可求
public class AnonymousInnerClassDemo1 {
    public static void main(String[] args) {
        // 使用匿名内部类直接创建子类对象
        // 外部类为 Animal 类，常规是创建一个抽象子类文件，然后写代码，这里直接用匿名内部类来作为子类，并重写抽象方法
        Animal a1 = new Animal() {
            @Override
            public void yell() {
                System.out.println("汪汪汪");
            }
        };

        // 使用场景
        // 之前我们在定义完接口类后，需要创建多个实现类，然后创建对象实例，再使用多态来将对象传入方法，然后操作
        // 现在我们直接不用定义专门的实现类，也不需要写一行代码另外创建对象（其实在创建对象时可以直接使用匿名内部类，上面a1那个就是这么操作），
        // 直接调用函数，在参数里写个匿名内部类来实现接口，并创建对象，直接作为参数传入
        desc(new AnimalInter() {
            @Override
            public void running() {
                System.out.println("老虎跑的快");
            }
        });
        desc(new AnimalInter() {
            @Override
            public void running() {
                System.out.println("乌龟跑的慢");
            }
        });
        // 当然，这个匿名内部类作为参数还可以简化，比如使用 lambda 表达式
        desc(() -> System.out.println("兔子跑的中等快"));
    }
    public static void desc(AnimalInter a) {
        a.running();
    }
}
