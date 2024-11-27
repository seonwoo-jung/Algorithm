package com.study.algorithm.personal.study.other;

import java.util.Arrays;

public class Main15 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int[] solution = solution(3, 5, 7, arr);
		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(int n, int left, int right, int[][] arr) {
		int[] answer = new int[right - left + 1];

		int idx = 0;

		for (int i = left; i <= right; i++) {
			int row = i / n;
			int col = i % n;
			answer[idx++] = arr[row][col];
		}

		return answer;
	}
}