package com.ethanc.exercises;

public class Test3 {
    public static void main(String[] args) {
        // 生成指定位数的验证码，每位可以是数字、大小写字母
        int num = 6;
        String code = getCode(num);
        System.out.println(code);
    }
    public static String getCode(int num) {
        String code = "";
        // 需要几位生成几个随机符
        for (int i = 0; i < num; i++) {
            // 1 确定是数字、小写还是大写字母
            int type = (int)(Math.random() * 3);
            // 2 分别按照不同类型生成该位随机码
            switch (type) {
                case 0:
                    // 数字：0-9
                    int thisNum = (int)(Math.random() * 10);
                    code += thisNum;
                    break;
                case 1:
                    // 小写字母：a-z
                    int ch1 = 'a' + (int)(Math.random() * 26);
                    code += (char)ch1;
                    break;
                case 2:
                    // 大写字母：A-Z
                    int ch2 = 'A' + (int)(Math.random() * 26);
                    code += (char)ch2;
                    break;
            }
        }
        return code;

    }
}
