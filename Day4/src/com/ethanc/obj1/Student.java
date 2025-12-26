package com.ethanc.obj1;

// 定义一个类
public class Student {
    // 0 静态变量（类变量）
    // 格式：前面加 static 关键字
    // 成员变量、成员方法不同的对象数据不互通，而静态变量，静态方法是类的，各个对象能共享
    // 其实可以从内存角度来理解，详情看图
    // 这里count用来记录该类总共创建了多少各对象
    // 因为每次创建对象都必先调用构造器，所以计数操作可写在构造器方法中
    public static int count = 0;


    // 1 成员变量与封装
    // 1.1 未作封装，向外暴露，可以直接用点方法访问、修改
    String name;
    public double weight;
    // 1.2 成员变量的封装：private 数据类型 成员变量名
    // 相应的要创建相应的成员方法，getter 和 setter 方法
    // 目的是不直接暴露在外界，通过成员方法来间接访问、修改成员变量，相应的调用对象属性的点方法失效。
    // 这么做的好处是在对象成员变量与外界调用之间提供了一个中间层，这一层可以做很多处理逻辑，比如限制范围、过滤等
    // 这提高了安全性，实际开发中，鼓励对象实例全部使用封装私有化

    // 其实有四种权限修饰符，按严苛条件排序为：private > 缺省 > protected > public
    // private 只能在本类中访问
    // 缺省 能在本类，同一个包下的类中访问
    // protected 能本类，同一个包下的类，不同包下的子类中访问(别忘了import)
    // public 能在任何地方访问
    // 实际开发，大多使用private和public，中间那俩不常用但看到了需要懂
    private double height;
    private int age;

    public void setHeight(double height) {
        if (height > 0 && height < 3) {
            // 1.3 this 关键字
            // this指向当前实例对象
            // 当方法的参数名与成员变量名相同时，可以通过this关键字来区分
            // 这里成员变量为height，参数也为height，所以这里用this.height区分，指向成员变量height
            // 问：可以不可以修改方法内参数名使其不重名而不用this呢，可以，但没必要
            // 其实你在类的方法内部直接用height是可以直接代表成员变量，但是内部也是加了this
            this.height = height;
        } else {
            System.out.println("请输入正确的身高");
        }
    }

    public double getHeight() {
        return this.height;
    }

    public void setAge(int age) {
        if (age > 0 && age < 180) {
            this.age = age;
        } else {
            System.out.println("请输入正确的年龄");
        }
    }

    public int getAge() {
        return age;
    }

    // 2 构造器方法
    // 分类：无参构造器方法，有参构造器方法
    // 所谓构造器，就是创建对象的方法。当实例化一个对象，如 new Student() 时自动调用。
    // 格式：修饰词 类名(参数列表) {}
    // 注意：一般修饰词用public，但当你定义的此类，不想创建实例时，可以使用private修饰
    // 私有的构造方法，外界无法调用，也就无法创建对象实例。这种概念一般用于创建工具类，内含多个公共工具类方法，只做调用工具方法使用不用创建对象

    // 2.1 当实例化一个对象，如 new Student()时，会自动调用默认的 无参构造器方法
    // 无参构造器
    // 2.2 当自己写了有参构造方法时，会自动调用有参构造方法，默认的无参构造器方法将失效，如果想用，只能自己重新定义一个无参构造器方法
    // 这极大的方便了创建对象，同时初始化对象成员变量的值，不用一个个属性调用setter了

    // 无参构造器方法
    public Student() {
        // 静态变量计数逻辑
        count++;
    }
    // 有参构造器方法
    // 这里其实内含了函数重载的知识，不传参就调用无参构造器，传参就调用有参构造器
    public Student(String name, double height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;

        // 静态变量计数逻辑
        count++;
    }

    // 3 成员方法
    // 当然，前面的getter 和 setter 方法，也是成员方法，写这里是为了讲解知识。实际上get set也要写在这里
    public void getInfo() {
        // 最好用this.name而不是直接name，虽然直接用name也指向成员变量，但还是规范化好。
        System.out.println("姓名：" + this.name + "\t身高：" + this.height + "\t年龄：" + this.age);
    }

    public static int getCount() {
        // 这里的count是静态变量，所以这里不能用this.count
        // this是指向实例对象的
        return count;
    }
}
