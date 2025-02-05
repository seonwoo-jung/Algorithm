package com.study.algorithm.inflearn.intro.ch10_dp;

import java.util.Arrays;

/**
 * 동전교환(냅색 알고리즘)
 */
public class Main5_동전교환 {

	private static int n, m;
	private static int[] dy;

	public static void main(String[] args) {
		n = 3;
		m = 15;
		int[] arr = new int[]{1, 2, 5};
		// 배열의 인덱스는 금액으로, 금액을 만드는 최소 동전 갯수
		dy = new int[m + 1];
		System.out.println(solution(arr));
	}

	private static int solution(int[] coin) {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;

		for (int i = 0; i < n; i++) {
			// 동전이 1원만 있을 때, 2원만 있을 때, 5원만 있을 때로 가정하고 계산
			for (int j = coin[i]; j <= m; j++) {
				// 가지고 있는 값보다 계산한 값이 작으면 바꾼다.
				dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
			}
		}

		return dy[m];
	}
}