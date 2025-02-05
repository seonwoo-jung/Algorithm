package com.study.algorithm.personal.sorting.basic;

import java.util.Arrays;

/**
 * pivot을 무작위로 정하는데, 계속 가장 작은 값만 정해지면 O(n^2)의 시간복잡도를 가진다 최악의 경우 O(n^2)까지 걸릴 수 있고, Unstable Sort임
 */
public class 퀵소트 {

	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);

		// 왼쪽 파티션
		if (start < part2 - 1) {
			quickSort(arr, start, part2 - 1);
		}

		// 오른쪽 파티션
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		// pivot은 배열의 중앙값이 좋지만, 중앙값이 뭔지 모르니, 배열 중앙 인덱스 값으로 둠
		int pivot = arr[(start + end) / 2];

		/**
		 * pivot이 가리키는 값을 기준으로 정렬한다.
		 * start가 가리키는 값이 pivot보다 작으면 skip, 크면 대기
		 * end가 가리키는 값이 pivot보다 크면 skip, 작으면 대기
		 */
		while (start <= end) {
			while (arr[start] < pivot) {
				start++;
			}
			while (arr[end] > pivot) {
				end--;
			}

			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}

		return start; // pivot보다 작은 파티션, 큰 파티션으로 나뉨. 큰 파티션의 인덱스를 반환함
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
}
