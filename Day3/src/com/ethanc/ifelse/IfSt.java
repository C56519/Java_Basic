package com.ethanc.ifelse;

// 逻辑判断
// if 语句, switch 语句
// 两者适合使用的场景不同：
// 如果条件为区间，使用if
// 如果条件是一个个值的比较时，使用switch（格式工整、性能好）
public class IfSt {
    public static void main(String[] args) {
        // 1 if 语句
        ifDemo1();
        ifDemo2();
        ifDemo3();

        // 2 switch 语句
        switchDemo();
    }
    // 1 if 语句
    // 1.1 if...else
    // 1.2 if...else if...else
    public static void ifDemo1() {
        int age = 18;
        if (age >= 18) {
            System.out.println("Pass");
        }
    }
    public static void ifDemo2() {
        int age = 17;
        if (age >=18) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
    public static void ifDemo3() {
        int score = 41;
        if (score >= 70) {
            System.out.println("优秀");
        } else if (score >= 50 && score < 60) {
            System.out.println("中等");
        } else if (score >= 40 && score < 50) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }

    // 2 switch 语句
    // switch (表达式) {}
    // 特点：表达式类型只能是int、char、byte、short、String、枚举类型，不支持float、double、long、boolean
    // 每个case值不允许重复，只能是字面量，不能是变量
    // 有穿透性
    public static void switchDemo() {
        // switch 语句
        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("及格");
                break;
            case 'D':
                System.out.println("不及格");
                break;
            default:
                System.out.println("未知等级");
                break;
        }

        // switch语句具有穿透性，也就是如果不写break，switch语句会自动执行下一个case的语句
        // 所以一般都不要忘记break，除非确定需要穿透
        int week = 2;
        switch (week) {
            // 当输入2时，会直接穿透到case3，以此类推，直接到case5遇到第一个break结束
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("必须为正确的星期");
                break;
        }

    }
}
