package com.skf.noob.chapter3;

/**
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等
 *
 * 局部最小概念:
 *
 * arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 *
 * @author: skf
 * @date: 2023/07/31
 */
public class BSAwesome {

	// arr 相邻的数不相等！
	public static int oneMinIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int n = arr.length;
		if (n == 1) {
			return 0;
		}
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[n - 1] < arr[n - 2]) {
			return n - 1;
		}
		int l = 0;
		int r = n - 1;
		// l...r 肯定有局部最小
		//while (l < r) {   // 140 14 87 9 114 179  数组越界
		while (l < r - 1) { // 保证最后剩余两个数时不报错
			int mid = (l + r) / 2;
			// 我<左 && 我<右
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			} else {
				// else有以下三种情况
				// 我 < 左、 我 > 右 (砍左边)
				// 我 > 左、 我 > 右 (砍右边)
				// 我 > 左、 我 < 右 (砍右边)
				if (arr[mid] > arr[mid - 1]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return arr[l] < arr[r] ? l : r;
	}

	// 生成随机数组，且相邻数不相等
	public static int[] randomArray(int maxLen, int maxValue) {
		int len = (int) (Math.random() * maxLen);
		int[] arr = new int[len];
		if (len > 0) {
			arr[0] = (int) (Math.random() * maxValue);
			for (int i = 1; i < len; i++) {
				do {
					arr[i] = (int) (Math.random() * maxValue);
				} while (arr[i] == arr[i - 1]);
			}
		}
		return arr;
	}

	// 也用于测试
	public static boolean check(int[] arr, int minIndex) {
		if (arr.length == 0) {
			return minIndex == -1;
		}
		int left = minIndex - 1;
		int right = minIndex + 1;
		boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
		boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
		return leftBigger && rightBigger;
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maxLen = 100;
		int maxValue = 200;
		int testTime = 1000000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = randomArray(maxLen, maxValue);
			//printArray(arr);
			int ans = oneMinIndex(arr);
			if (!check(arr, ans)) {
				printArray(arr);
				System.out.println(ans);
				break;
			}
		}
		System.out.println("测试结束");

	}

}