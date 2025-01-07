package com.study.algorithm.inflearn.middle.ch09_dp.intro;

import java.util.Arrays;

public class Main5_동전교환 {

	private static int[] dy;

	public static void main(String[] args) {
		System.out.println(solution(3, new int[]{1, 2, 5}, 15));
	}

	private static int solution(int n, int[] coin, int m) {
		dy = new int[m + 1];
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		// 동전 종류 인덱스
		for (int i = 0; i < n; i++) {
			// 동전 값부터 for문 시작
			for (int j = coin[i]; j <= m; j++) {
				dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
			}
		}
		return dy[m];
	}
}
