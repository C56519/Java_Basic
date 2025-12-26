package com.ethanc.exercises;

public class Test4 {
    public static void main(String[] args) {
        int primeNum = 0;
        // 判断101-200之间有多少个素数，并输出所有素数
        for (int i = 101; i <= 200; i++) {
            boolean flag = isPrime(i);
            if (flag) {
                System.out.print(i + "\t");
                primeNum++;
            }
        }
        System.out.println();
        System.out.println("素数的个数为：" + primeNum);
    }
    // 判断该数是否为素数
    public static boolean isPrime(int n) {
        // 素数除了1和自身外，不能被其他数整除
        // 假设n能够分解为 a × b，且假设 a <= b
        // 那么 a × b = n， 排除1，排除自身，得到 2 <= a <= b < n
        // 又因为数学上 √n × √n = n，那么必有 a <= √n <= b，所以只需把a找出来就完事，减少算力
        // 而a的范围为 2 <= a <= √n，所以右区间为 √n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
