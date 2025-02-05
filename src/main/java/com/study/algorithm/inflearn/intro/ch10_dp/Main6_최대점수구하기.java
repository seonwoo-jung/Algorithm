package com.study.algorithm.inflearn.intro.ch10_dp;

import java.util.Scanner;

/**
 * 최대점수 구하기(냅색 알고리즘)
 */
public class Main6_최대점수구하기 {

	private static int n, m;
	private static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // 문제 개수
		m = kb.nextInt(); // 제한 시간
		dy = new int[m + 1]; // dy의 index 번호는 주어진 시간임

		for (int i = 0; i < n; i++) {
			int score = kb.nextInt();
			int time = kb.nextInt();
			for (int j = m; j >= time; j--) {
				dy[j] = Math.max(dy[j], dy[j - time] + score);
			}
		}
		System.out.println(dy[m]);
	}
}