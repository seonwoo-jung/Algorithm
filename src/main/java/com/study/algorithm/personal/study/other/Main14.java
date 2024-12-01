package com.study.algorithm.personal.study.other;

import java.util.Arrays;

public class Main14 {

	public static void main(String[] args) {
		int n = 8;
		int m = 32;
		int[] arr = new int[]{23, 87, 65, 12, 57, 32, 99, 81};
		int solution = solution(n, m, arr);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n, int m, int[] arr) {
		int lt = 0, rt = n - 1, answer = 0;

		Arrays.sort(arr);

		while (lt <= rt) {
			int mid = (lt + rt) / 2;

			if (arr[mid] == m) {
				answer = mid + 1;
				break;
			}

			if (arr[mid] > m) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}

		return answer;
	}
}