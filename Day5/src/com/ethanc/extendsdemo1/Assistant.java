package com.ethanc.extendsdemo1;

public class Assistant extends People{
    // 子类的独有成员变量，所解答问题的人数
    private String peopleNum;
    private String schoolName;

    // 子类构造器
    // 为了方便初始化对象，所以使用构造器方法。
    // 比如：如果不使用这个方法，那么当new子类对象后，需要一个个调用setter来赋值
    // 配置构造器后，可以实现一行代码完成对象初始化 new Assistant("Tom", "男"， 1.68, 17);

    // super()：用来调用父类的构造器，如果调父类的有参，则传入参数。    super(a, b)
    //          如果调父类的无参，则不传入参数。    super()
    //          注意：super()必须在构造器的第一行。
    //          使用情况：一般在简化实例化子类对象时使用
    // this()： 用来调用自己类中的其他构造器，如果调本类的有参，则传入参数。    this(a, b)
    //          如果调本类的无参，则不传入参数。    this()
    //          注意：this()也必须在构造器的第一行。
    //          使用情况：一般用来设置子类的默认属性值，比如下面例子，将schoolName写死，这样创建对象时，可以不传入该参数，但创建后，自动添加该属性。
    // 二者不能同时使用，只能存在一个。因为都必须在第一行所以冲突。
    // 二者都只能出现在构造器方法中，别的地方不能用。

    // 演示 this()和super()
    public Assistant(String name, int age, String sex, String peopleName) {
        // 构造器1：实现传入三个参数，就能构造完整对象的功能，自动添加默认学校名称
        // 用this()调用本类中的完整参数构造器，添加默认学校名称
        this(name, age, sex, peopleName,"Cardiff University");
    }
    public Assistant(String name, int age, String sex, String peopleName, String schoolName) {
        // 调用父类有参构造器，来继承父类公共的属性到子类中
        super(name, age, sex);
        // 另添加子类自己的属性，整合完成对象初始化
        this.peopleNum = peopleName;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
