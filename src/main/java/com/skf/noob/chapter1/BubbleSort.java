package com.skf.noob.chapter1;

/**
 * 冒泡排序
 *
 * @author: skf
 * @date: 2023/07/30
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 4, 8, 5, 10, 9, 2, 4, 1};
        printArrStr(arr);
        bubbleSort(arr);
        printArrStr(arr);
    }

    private static void bubbleSort(int[] arr) {
        // 边界判断
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
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
