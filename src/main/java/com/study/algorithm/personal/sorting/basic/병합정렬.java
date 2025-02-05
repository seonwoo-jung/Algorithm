package com.study.algorithm.personal.sorting.basic;

import java.util.Arrays;

public class 병합정렬 {

	private static int[] arr, tmp;

	public static void main(String[] args) {
		arr = new int[]{3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		tmp = new int[arr.length];

		mergeSort();
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort() {
		mergeSort(0, arr.length - 1);
	}

	private static void mergeSort(int lt, int rt) {
		if (lt < rt) {
			int mid = (lt + rt) / 2;
			mergeSort(lt, mid);
			mergeSort(mid + 1, rt);
			merge(lt, mid, rt);
		}
	}

	private static void merge(int lt, int mid, int rt) {
		for (int i = lt; i <= rt; i++) {
			tmp[i] = arr[i];
		}
		int part1 = lt; 	 // 왼쪽 부분 시작 인덱스
		int part2 = mid + 1; // 오른쪽 부분 시작 인덱스
		int index = lt;		 // 원본 배열에 병합한 결과를 기록할 인덱스 (lt부터 시작).

		while (part1 <= mid && part2 <= rt) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}

		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
}
