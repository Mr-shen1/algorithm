package com.skf.noob.chapter1;

/**
 * @author: skf
 * @date: 2023/07/30
 */
public class PrintIntegerByte {
    public static void main(String[] args) {
        //print(1);
        //print(2434);
        // 01111111111111111111111111111111 2 ^ 31 - 1(0占了一位, 所以减一)
        // 第一位为符号位, 0代表正数, 1代表负数
        print(Integer.MAX_VALUE);
        // 10000000000000000000000000000000 (-2 ^ 31)
        // 1表示负数, 具体的值为后面31位取反+1即 ~num + 1
        // 即 ~0000000000000000000000000000000 + 1
        print(Integer.MIN_VALUE);

        // 00000000000000000000000000000101
        print(5);
        // 相反数的计算: 取反 + 1
        // 对5取反后: 11111111111111111111111111111010
        // 取反后 + 1:  11111111111111111111111111111011 即 (-5)
        print(-5);

        // Integer.MIN_VALUE的相反数还是Integer.MIN_VALUE ()
        // 取反 + 1后还是原来不变
        // Integer最大才2 ^ 31 - 1, 最小负数的绝对值是会比最大正数的绝对值大1的
        print(-Integer.MIN_VALUE); // 10000000000000000000000000000000
    }

    /**
     * 打印一个int类型数字的32为二进制字符
     *
     * @param num num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
