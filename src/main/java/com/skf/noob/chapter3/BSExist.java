package com.skf.noob.chapter3;

/**
 * 二分查找
 *
 * @author: skf
 * @date: 2023/07/31
 */
public class BSExist {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 8, 9, 11, 14, 16, 17, 23, 67, 85};
        int num = 8;
        System.out.println(exist(arr, num));
    }

    private static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            // 防止超范围
            int mid = r - (r - l) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else if (arr[mid] < num) {
                l = mid + 1;
            }
        }
        return false;
    }
}
