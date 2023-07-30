package com.skf.noob.chapter2;

/**
 * 使用对数器验证插入排序和选择排序是否正确
 *
 * @author: skf
 * @date: 2023/07/30
 */
public class Comp {

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


	private static void insertionSort(int[] arr) {
		// 边界判断
		if (arr == null || arr.length < 2) {
			return;
		}
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j -1 >= 0 && arr[j - 1] > arr[j]; j--) {
				swap(arr, j - 1, j);
			}

		}
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	// 返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
	public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
		int len = (int) (Math.random() * maxLen);
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			ans[i] = (int) (Math.random() * maxValue);
		}
		return ans;
	}

	public static int[] copyArray(int[] arr) {
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

	// arr1和arr2一定等长
	public static boolean isSorted(int[] arr) {
		if (arr.length < 2) {
			return true;
		}
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max > arr[i]) {
				return false;
			}
			max = Math.max(max, arr[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		int maxLen = 5;
		int maxValue = 1000;
		int testTime = 10000;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
			int[] tmp = copyArray(arr1);
			selectSort(arr1);
			if (!isSorted(arr1)) {
				for (int j = 0; j < tmp.length; j++) {
					System.out.print(tmp[j] + " ");
				}
				System.out.println();
				System.out.println("选择排序错了！");
				break;
			}
			int[] arr2 = lenRandomValueRandom(maxLen, maxValue);
			insertionSort(arr2);

			if (!isSorted(arr2)) {
				for (int j = 0; j < tmp.length; j++) {
					System.out.print(tmp[j] + " ");
				}
				System.out.println();
				System.out.println("插入排序错了！");
				break;
			}
		}

	}

}