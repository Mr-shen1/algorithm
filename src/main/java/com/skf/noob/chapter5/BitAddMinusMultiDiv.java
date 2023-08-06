package com.skf.noob.chapter5;

/**
 * 使用位运算实现加减乘除
 *
 * @author: shenkefeng
 * @date: 2023/08/06
 */
public class BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

    /**
     * a - b就是 a + b的相反数
     * 而一个数的相反数为 取反后 + 1
     *
     * @param a a
     * @param b a
     * @return minus
     */
    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = add(20, 46);
        System.out.println(sum);
        int minus = minus(sum, 46);
        System.out.println(minus);

        int a = -4;
        int b = -2;
        System.out.println(multi(a, b));
    }
}
