package com.ethanc.extendsdemo1;

public class Teacher extends People {
    // 子类独有的成员变量
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    // 方法重写
    // 如果是同名且参数列表一样的方法，覆盖了父类方法，叫做方法重写。一般用于覆盖父类方法逻辑，展示自己逻辑
    // 注意：
    // 1. 强烈推荐在子类需要重写的方法前加@Override注解，可以来校验方法名称和参数列表是否与被重写方法一致，不一致就自动报错
    // 2. 子类重写方法的权限修饰符必须 >= 父类被重写方法的权限修饰符（public > protected > 省却）
    // 3. 子类重写方法返回值类型，范围必须 <= 父类被重写方法的返回值类型（Object最大）
    // 4. 私有方法、静态方法不能被重写，否则会报错
    @Override
    public void showIncome(int income) {
        System.out.println("讲师的收入为：" + income);
    }
}
