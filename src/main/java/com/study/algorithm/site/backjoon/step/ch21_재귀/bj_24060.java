package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_24060 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2; // 중간 지점 계산
			mergeSort(arr, p, q);  // 전반부 정렬
			mergeSort(arr, q + 1, r); // 후반부 정렬
			merge(arr, p, q, r); // 병합
		}
	}

	public static void merge(int[] arr, int p, int q, int r) {
		int[] tmp = new int[r - p + 1]; // 임시 배열 생성
		int i = p, j = q + 1, t = 0;

		// 두 부분 배열을 병합
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}

		// 왼쪽 배열의 나머지 복사
		while (i <= q) {
			tmp[t++] = arr[i++];
		}

		// 오른쪽 배열의 나머지 복사
		while (j <= r) {
			tmp[t++] = arr[j++];
		}

		// tmp 배열의 내용을 원본 배열 A에 복사
		t = 0;
		for (i = p; i <= r; i++) {
			arr[i] = tmp[t++];
		}
	}
}