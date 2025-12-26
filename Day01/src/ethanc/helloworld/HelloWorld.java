package ethanc.helloworld;
import java.util.Scanner;
/*
 * 1. 各个关键字的解释, 文件名、包名、类名的命名规则
 *   1.1 文件名：首字母大写，大驼峰命名法，HelloWorld.java
 *   1.2 包名：全小写，采用域名反转方式，最后那个是包的作用 com.ethanc.helloworld
 *   1.3 类名：首字母大写，大驼峰命名法，HelloWorld
 *   1.4 变量与方法：数字、字母、下划线、$，首字母不能是数字，小驼峰
 * 2. 行注释与块注释，快捷键：行 ctrl+/ 块 ctrl+shift+/
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // 输入
        // int为 sc.nextInt(), String为 sc.next(), double为 sc.nextDouble(), long为 sc.nextLong(), float为 sc.nextFloat(),
        // boolean为 sc.nextBoolean(), 数组为 sc.nextLine().split(" ")
        Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // System.out.println(num);
        String str = sc.next();
        System.out.println(str);
    }
}
