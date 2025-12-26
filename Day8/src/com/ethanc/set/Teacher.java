package com.ethanc.set;

public class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    public Teacher() {
    }
    public Teacher(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }

    /**
     * 重写Comparable接口中的 compareTo方法，指定比较规则
     * @param o 源码为泛型T，这里传入Teacher对象
     * @return 返回正数（如果你认为第一个值大于第二个值）、负数（反之）、0（相等）
     */
    @Override
    public int compareTo(Teacher o) {
/*        if (this.getAge() > o.getAge()) {
            return 1;
        } else if (this.getAge() < o.getAge()) {
            return -1;
        } else {
            return 0;
        }*/
        // 可直接简写为
        return this.getAge() - o.getAge();
    }
}
