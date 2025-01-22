package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_24060 {

	private static int[] tmp;
	private static int result = -1;
	private static int cnt = 0;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		tmp = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(A, 0, N - 1);

		System.out.println(result);
	}

	private static void merge_sort(int[] array, int p, int r) {
		if (cnt > K) {
			return; //저장 횟수가 진행 횟수보다 넘어가게 되면 더이상 분해 or 병합 진행X
		}
		if (p < r) {
			int q = (p + r) / 2; //중간으로 쪼갠다.
			merge_sort(array, p, q);   //전반부 정렬
			merge_sort(array, q + 1, r); //후반부 정렬
			merge(array, p, q, r); //병합
		}
	}

	private static void merge(int[] array, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (array[i] < array[j]) {
				tmp[t++] = array[i++];
			} else {
				tmp[t++] = array[j++];
			}
		}

		while (i <= q) {
			tmp[t++] = array[i++];
		}

		while (j <= r) {
			tmp[t++] = array[j++];
		}

		i = p;
		t = 0;
		while (i <= r) {
			cnt++;

			if (cnt == K) {
				result = tmp[t];
				break;
			}

			array[i++] = tmp[t++];
		}
	}
}