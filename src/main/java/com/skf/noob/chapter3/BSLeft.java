package com.skf.noob.chapter3;

/**
 * 二分查找
 *
 * @author: skf
 * @date: 2023/07/31
 */
public class BSLeft {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 7, 8, 8, 8, 8, 8, 9, 11, 14, 16, 17, 23, 67, 85};
        int num = 8;
        System.out.println(findLeft(arr, num));
    }

    /**
     * 有序数组中找到>=num最左的位置
     * @param arr arr
     * @param num num
     * @return index
     */
    public static int findLeft(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int result = -1;
        while (l <= r) {
            // 防止超范围
            int mid = r - (r - l) / 2;
            if (arr[mid] >= num) {
                r = mid - 1;
                result = mid;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
