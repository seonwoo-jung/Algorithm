package com.study.algorithm.personal.sorting;

import java.util.Arrays;

public class 듀얼피벗퀵소트 {

	public static void main(String[] args) {
		int[] array = {3, 1, 5, 9, 4, 8, 7};
		dualPivotQuickSort(array);
		System.out.println(Arrays.toString(array));
	}

	// 메소드 시작
	private static void dualPivotQuickSort(int[] array) {
		dualPivotQuickSort(array, 0, array.length - 1);
	}

	// 듀얼 피벗 퀵소트 정렬 시작
	// 피벗 2개를 설정하여 영역을 정렬
	private static void dualPivotQuickSort(int[] array, int low, int high) {

		if (low < high) {

			// 1. pivot1 < pivot2 조건을 만족하기 위해
			if (array[low] > array[high]) {
				swap(array, low, high);
			}

			int pivot1 = array[low];
			int pivot2 = array[high];

			int lt = low + 1;  // pivot1보다 작은 요소들이 위치할 영역의 시작점을 나타내며,
			int gt = high - 1; // pivot2보다 큰 요소들이 위치할 영역의 끝점을 나타냅니다.
			int i = low + 1;   // 현재 검사하는 인덱스

			while (i <= gt) {
				if (array[i] < pivot1) { // 해당 요소는 첫 번째 피벗보다 작으므로, lt에 둠
					swap(array, i++, lt++);
				} else if (array[i] > pivot2) { // 해당 요소는 두 번째 피벗보다 크므로, gt에 둠
					swap(array, i, gt--);
				} else {
					i++; // pivot1과 pivot2 사이에 있는 경우 swap없이 i만 증가
				}
			}

			// 피벗 최종 위치 조정
			swap(array, low, --lt);
			swap(array, high, ++gt);

			// 재귀적으로 정렬
			dualPivotQuickSort(array, low, lt - 1);
			dualPivotQuickSort(array, lt + 1, gt - 1);
			dualPivotQuickSort(array, gt + 1, high);
		}
	}

	// 위치 교환 메소드
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}