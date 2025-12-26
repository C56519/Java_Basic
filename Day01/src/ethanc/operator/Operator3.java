package ethanc.operator;

// 自增自减运算符，赋值运算符，关系运算符，三元运算符，逻辑运算符
public class Operator3 {
    public static void main(String[] args) {
        selfIncrease();
        assignmentOperator();
        relationalOperator();
        ternaryOperator();
        logicOperator();
    }

    // 1 自增自减运算符
    public static void selfIncrease() {
        // a++ 可以理解为：a = a + 1
        // 1.1 单独使用运算符
        int a = 10;
        a++;
        System.out.println(a);  // 11
        ++a;
        System.out.println(a);  // 12

        // 1.2 与赋值一起使用
        // a++ 先用后加，++a 先加后用
        int b = 10;
        int c = b++;
        System.out.println(c);  // 10   先将b的值赋给c，b再加1
        System.out.println(b);  // 11

        int d = 10;
        int e = ++d;
        System.out.println(e);  // 11   先d加1，再赋给e
        System.out.println(d);  // 11

        // a--, --a也一样
    }

    // 2 赋值运算符
    public static void assignmentOperator() {
        // a+=b => a = a + b
        // a-=b a*=b a/=b a%=b
        // Java的赋值运算符隐含了强制类型转换 a+=b => a = (a的类型) (a + b)
        int a = 10, b = 3;
        a += b; // 13
        System.out.println(a);

        byte c = 10, d = 2;
        c += d; // 等价于 c = (byte)(c + d)
        System.out.println(c);

    }

    // 3 关系运算符
    public static void relationalOperator() {
        // > < >= <= == !=
        int a = 10, b = 3;
        System.out.println(a > b);
        System.out.println(a == b);
        System.out.println(a != b);
    }

    // 4 三元运算符
    public static void ternaryOperator() {
        // a > b ? a : b    先判断a是否大于b，是则返回a，不是则返回b
        int a = 10, b = 3;
        int c = a > b ? a : b;
        System.out.println(c);

        // 可以嵌套
        int score = 68;
        String grade = score >= 70 ? "优秀" : score>= 60 ? "良好" : score >= 50 ? "及格" : "不及格";
        System.out.println(grade);

        // 嵌套练习
        int max = getMax(10, 20, 30);
        System.out.println(max);

    }
    // 嵌套练习
    public static int getMax(int a, int b, int c) {
        // 从三个整数中获取最大的那个数
//        int max = a > b ? a : b;
//        max = max > c ? max : c;
//        return max;
        int max = a > b
                ? (a > c ? a : c)
                : (b > c ? b : c);
        // 解读：最好不要写成一行，可读性差，像这样分行写比较容易读。
        // 先看a是否大于b，
        // 是则走第一路：继续判断a是否大于c，是则返回a，不是则返回c
        // 不是则走第二路：继续判断b是否大于c，是则返回b，不是则返回c
        return max;
    }

    // 5 逻辑运算符
    public static void logicOperator() {
        // 5.1 常规
        // 与: &    或: |   非: !    异或: ^
        // 运算符左右都进行一次判断
        // 与: &     全真时才真
        // 或: |      全假时才假
        // 非: !       逻辑非，取反
        // 异或: ^      前后结果相同为假，不同为真

        // 5.2 短路运算符
        // 短路与: &&   短路或: ||
        // 运算符左右不全进行判断了，从左到右开始判断，
        // 短路与: &&  左边为假则直接返回假，不再判断右边。为真则继续判断右边
        // 短路或: ||   左边为真则直接返回真，不再判断右边。为假则继续判断右边

        int a = 10, b = 0;
        System.out.println(a > b & b > 0);  // false
        System.out.println(a > b && b > 0); // false

        System.out.println(a > b | b > 0);  //  true
        System.out.println(a > b || b > 0); //  true

        System.out.println(!(a > b));   // false

        System.out.println(a > b ^ b > 0);  // true

        // 验证短路
        System.out.println(a > b || ++b > 0);
        System.out.println(b);  // 因为短路，++b没有被执行，所以b还是0
    }
}
