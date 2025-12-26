package com.ethanc.recursion;
import java.util.Arrays;

/**
 * 1. 几个字符集：
 * - ASCII字符集：只有英文、数字、符号等，占1个字节。
 * - GBK字符集：汉字占2个字节，英文、数字占1个字节。
 * - UTF-8字符集：汉字占3个字节，英文、数字占1个字节。
 * 2. 注意：
 *      a. 字符编码时使用的字符集，和解码时使用的字符集必须一致，否则会出现乱码
 *      b. 英文，数字一般不会乱码，因为很多字符集都兼容了ASCII编码。
 *
 * 3. UTF-8编码
 * UTF-8是Unicode字符集的一种编码方案，采取可变长编码方案，共分四个长度区：
 * 1个字节，2个字节，3个字节，4个字节
 * - 英文字符、数字等只占1个字节（兼容标准ASCII编码）
 * - 汉字字符占用3个字节
 *
 * UTF-8编码方式(二进制)：以前缀码进行编码和解码
 * 0xxxxxxx (ASCII码)                    以0开头为一字节区
 * 110xxxxx 10xxxxxx                     一个比特区110开头，另一个以10开头为二字节区
 * 1110xxxx 10xxxxxx 10xxxxxx            一个比特区1110开头，两个以10开头为三字节区
 * 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx  同理
 *
 * 注意：技术人员在开发时都应该使用UTF-8编码！
 *
 * 如：a我m这三个字符怎么区分？
 * | 字符 | Unicode十进制 | UTF-8二进制编码        |
 * |------|--------------|----------------------|
 * | a    | 97           | 01100001             |
 * | 我   | 25105        | 11100110 10001000 10010001 |
 * | m    | 109          | 01101101             |
 *
 * 4. Java 中实现编码和解码
 * 对字符进行编码
 * - String类下的方法：
 *   - byte[] getBytes(): 默认编码
 *   - byte[] getBytes(String charsetName): 指定编码
 *
 *   对字节进行解码？
 * - String类的构造器：
 *   - String(byte[] bytes): 使用默认编码解码
 *   - String(byte[] bytes, String charsetName): 指定编码解码
 */
//df
public class ASCIIDemo {
    public static void main(String[] args) {
        // 实现字符的编码和解码
        String name = "我Love中国666";
        // 编码
        byte[] bytes = name.getBytes(); // 默认使用UTF-8编码
        // byte[] bytes = name.getBytes("GBK"); // 指定使用GBK字符集编码
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        // 解码
        String name2 = new String(bytes);
        System.out.println(name2);
    }
}
