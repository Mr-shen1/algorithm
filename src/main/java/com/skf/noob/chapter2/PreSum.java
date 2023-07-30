package com.skf.noob.chapter2;

import java.util.Arrays;

/**
 * 前缀和
 *
 * @author: skf
 * @date: 2023/07/30
 */
public class PreSum {
    static int[] preSumArr;

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 2, 5, 7, 3, 7, 1, 4, 9, 8};
        // 获取arr数组中第l到第r位置的和

        int[] preSumArr = getPreSumArr(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(preSumArr));
        System.out.println(rangeSum(2,5));
    }

    private static int[] getPreSumArr(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        preSumArr = new int[arr.length];
        preSumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }
        return preSumArr;
    }

    private static int rangeSum(int l, int r) {
        if (l == 0) {
            return preSumArr[r];
        }
        return preSumArr[r] - preSumArr[l -1];
    }
}
