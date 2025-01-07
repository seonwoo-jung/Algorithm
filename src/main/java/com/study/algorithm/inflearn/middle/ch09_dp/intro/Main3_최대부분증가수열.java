package com.study.algorithm.inflearn.middle.ch09_dp.intro;

import java.util.Arrays;

public class Main3_최대부분증가수열 {

	private static int[] dy;

	public static void main(String[] args) {
		System.out.println(solution(7, new int[]{5, 3, 7, 8, 6, 2, 9, 4}));
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && dy[j] > max) {
					max = dy[j];
				}
			}

			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(Arrays.toString(dy));
		return answer;
	}
}
