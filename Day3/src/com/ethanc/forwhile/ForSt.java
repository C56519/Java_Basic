package com.ethanc.forwhile;

// 循环结构
// for 和 while
// 二者功能一样，但当知道循环几次时，用for；不知道建议用while
public class ForSt {
    public static void main(String[] args) {
        forDemo1();
        forDemo2();
        forDemo3();

        whileDemo1();
        whileDemo2();

        doWhileDemo();

        nestLoop();

        bcDemo1();
    }

    // 1 for 循环
    public static void forDemo1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    // 练习：打印1-5的累加和
    public static void forDemo2() {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    // 练习：打印1到10的奇数和
    public static void forDemo3() {
        int sum = 0;
        for (int i = 1; i <= 10; i+=2) {
            sum += i;
        }
        System.out.println(sum);
    }

    // 2 while 循环
    // 练习：本金10000，年利率1.7%，问多少年后能实现本金翻倍
    public static void whileDemo1() {
        // 定义变量
        double money = 10000;
        int year = 0;
        double rate = 0.017;
        // 循环体
        while (money < 20000) {
            money *= 1 + rate;
            year++;
        }
        // 打印
        System.out.println(year);
    }

    // 练习：珠穆朗玛峰高8848.86m，如果有一张足够大的纸，厚度0.1毫米，问折叠几次能达到珠穆朗玛峰的高度
    public static void whileDemo2() {
        double height = 8848.86 * 1000;
        double thickness = 0.1;
        int count = 0;
        while (thickness < height) {
            thickness *= 2;
            count++;
        }
        System.out.println(count);
    }

    // 3 do...while 循环
    public static void doWhileDemo() {
        // do while先执行后判断，一定会执行一次。而for和while都是先判断后执行
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i <= 5);
    }

    // 4 死循环
    public static void deadLoop() {
/*        // 三种死循环
        while(true) {
            System.out.println("死循环");
        }
        for (; ;) {
            System.out.println("死循环");
        }
        do {
            System.out.println("死循环");
        } while (true);*/
    }

    // 5 嵌套循环
    // 练习：打印一个乘法表
    public static void nestLoop() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i + " x " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 6 break 和 continue 关键字
    // break 直接跳出并结束循环
    // continue 跳过当前循环次序，继续下一次循环
    public static void bcDemo1() {
        // break
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.print(i + "\t"); //1 2
        }
        // continue
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + "\t"); //1 2 4 5
        }
    }
}
