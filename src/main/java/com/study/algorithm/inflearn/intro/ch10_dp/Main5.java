package com.study.algorithm.inflearn.intro.ch10_dp;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전교환(냅색 알고리즘)
 */
public class Main5 {

	private static int n, m;
	private static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) arr[i] = kb.nextInt();
		m = kb.nextInt();
		dy = new int[m + 1];
		System.out.println(solution(arr));
	}

	private static int solution(int[] coin) {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= m; j++) {
				dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
			}
		}

		return dy[m];
	}
}