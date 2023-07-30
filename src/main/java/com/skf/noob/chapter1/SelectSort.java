package com.skf.noob.chapter1;

/**
 * 选择排序
 *
 * @author: skf
 * @date: 2023/07/30
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 4, 8, 5, 9};
        printArrStr(arr);
        selectSort(arr);
        printArrStr(arr);
    }

    private static void selectSort(int[] arr) {
        // 边界判断
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArrStr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
