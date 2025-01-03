package com.study.algorithm.inflearn.intro.ch10_dp;

import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.max;
import static java.lang.System.in;
import static java.util.Arrays.fill;

/**
 * 최대점수 구하기(냅색 알고리즘)
 */
public class Main6 {

	private static int n, m;
	private static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt(); // 문제 개수
		m = kb.nextInt(); // 제한 시간
		dy = new int[m + 1]; // dy의 index 번호는 주어진 시간임
		for (int i = 0; i < n; i++) {
			int ps = kb.nextInt();
			int pt = kb.nextInt();
			for (int j = m; j >= pt; j--) {
				dy[j] = max(dy[j], dy[j - pt] + ps);
			}
		}
		System.out.println(dy[m]);
	}

	private static int solution(int[] coin) {
		fill(dy, MAX_VALUE);
		dy[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= m; j++) {
				dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
			}
		}
		return dy[m];
	}
}