package com.study.algorithm.personal.study.other;

import java.util.Arrays;

/**
 * pivot을 무작위로 정하는데, 계속 가장 작은 값만 정해지면 O(n^2)의 시간복잡도를 가진다 최악의 경우 O(n^2)까지 걸릴 수 있고, Unstable Sort임
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 6, 2, 9, 1};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);

		if (start < part2 - 1) {
			quickSort(arr, start, part2 - 1);
		}

		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];

		while (start <= end) {
			while (arr[start] < pivot) start++;
			while (arr[end] > pivot) end--;
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
}
