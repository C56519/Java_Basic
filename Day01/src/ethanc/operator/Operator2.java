package ethanc.operator;
import java.util.Scanner;

public class Operator2 {
    public static void main(String[] args) {
        // 练习：键盘输入一个三位数，输出个位、十位、百位。

        // 1 键盘输入
        System.out.println("请输入一个三位数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 2 计算个位数
        // 将数与10进行取余运算，余数就是个位数
        int ge = num % 10;

        // 3 计算十位数
        // 将数除10，取商，商就是十位数。为了规范化，对齐个位的运算，将商再与10做取余运算。
        int shi = num / 10 % 10;

        // 4 获取百位数
        // 将数除100，取商，商就是百位数。为了规范化，对齐个位的运算，将商再与10做取余运算。
        int bai = num / 100 % 10;

        // 5 输出
        System.out.println("百位：" + bai + "，十位：" + shi + "，个位：" + ge);

        // 6 算法总结：获得一个数的数位
        // 个位：数值 % 10
        // 十位：数值 / 10 % 10
        // 百位：数值 / 100 % 10
        // 千位：数值 / 1000 % 10

    }
}
