package ethanc.operator;

public class Operator1 {
    public static void main(String[] args) {
        // 1 数值计算
        // 1.1 整数计算
        // Java 整数与整数计算结果全为整数
        int a = 10, b = 3;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);  // 3，相当于舍弃了所有小数位，做了一次取商运算
        System.out.println(a % b);  // 1， 取余运算

        // 1.2 浮点数计算
        // Java 浮点数计算结果全为浮点数，结果可能不精确。这里为自动类型转换知识
        double c = 10.0, d = 3.0;
        System.out.println(c * d);
        System.out.println(c / d);

        // +运算符与字符、字符串的计算
        // 字符char类型是能参与整数计算的，先找到其对应的ASCII码，再与整数计算得到一个整数结果
        // 而字符串参与计算就是字符串拼接了，直接将整数拼到字符串里
        System.out.println(1 + 'a');    // 98
        System.out.println(1 + "abc");  // 1abc
        System.out.println(1 + 'a' + "abc");    // 98abc
    }
}
