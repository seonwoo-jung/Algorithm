package com.study.algorithm.personal.sorting;

import java.util.Arrays;

/**
 * 병합정렬을 기반으로 구현하되, 일정 크기 이하의 부분 리스트에 대해서는 삽입 정렬을 수행한다.
 */
public class 팀소트 {

	// 런의 크기 설정
	private static final int RUN = 32;

	public static void main(String[] args) {
		int[] array = {3, 1, 5, 9, 4, 8, 7};
		timSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}

	private static void timSort(int[] array) {
		int n = array.length;

		// 런 크기에 따라 배열을 여러 부분으로 나누고 각 부분에 대해 삽입 정렬 수행한다.
		for (int i = 0; i < n; i += RUN) {
			insertionSort(array, i, Math.min((i + RUN - 1), n - 1));
		}

		for (int size = RUN; size < n; size = 2 * size) {
			for (int lt = 0; lt < n; lt += 2 * size) {
				int mid = lt + size - 1; // 첫 번째 런의 마지막 인덱스
				int rt = Math.min((lt + 2 * size - 1), (n - 1)); // 두 번째 런의 마지막 인덱스

				if (mid < rt) { // 두런이 겹치지 않을 경우에 병합을 수행
					merge(array, lt, mid, rt);
				}
			}
		}
	}

	// 삽입 정렬
	private static void insertionSort(int[] array, int lt, int rt) {
		for (int i = lt + 1; i <= rt; i++) {

			// 탐색하는 값이 앞의 값보다 작으면 위치를 바꿈
			// 즉, 앞의 값이 작을 때까지 계속 앞으로 보내서 정렬시킴
			int temp = array[i];
			int j = i - 1;

			while (j >= lt && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}

	// 배열의 두 부분을 병합하는 메소드
	private static void merge(int[] array, int l, int m, int r) {
		// 병합할 두 부분 배열의 크기를 찾는다.
		int len1 = m - l + 1;
		int len2 = r - m;

		int[] lt = new int[len1];
		int[] rt = new int[len2];

		// 데이터를 임시 배열로 복사
		System.arraycopy(array, l, lt, 0, len1);
		System.arraycopy(array, m + 1, rt, 0, len2);

		// 병합 과정
		int i = 0; // left 인덱스
		int j = 0; // right 인덱스
		int k = l; // 병합 될 배열의 인덱스

		while (i < len1 && j < len2) {
			if (lt[i] <= rt[j]) {
				array[k++] = lt[i++];
			} else {
				array[k++] = rt[j++];
			}
		}

		// 남은 요소 복사
		while (i < len1) {
			array[k++] = lt[i++];
		}
		while (j < len2) {
			array[k++] = rt[j++];
		}

	}
}
