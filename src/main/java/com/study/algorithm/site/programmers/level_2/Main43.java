package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main43 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{3, 5}})));
		System.out.println(Arrays.toString(solution(new int[][]{{3, 8}, {2, 2}})));
		System.out.println(Arrays.toString(solution(new int[][]{{3, 1}, {2, 3}, {3, 9}})));
		System.out.println(Arrays.toString(solution(new int[][]{{4, 26}})));
	}

	private static String[] solution(int[][] queries) {
		String[] result = new String[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = queries[i][0] == 1 ? "Rr" : recursive(queries[i][0], queries[i][1]);
		}
		return result;
	}

	private static String recursive(int n, int p) {
		int cnt = (int) Math.pow(4, n - 1);
		if (p <= cnt / 4) {
			return "RR";
		}
		if (p > cnt / 4 * 3) {
			return "rr";
		}
		if (n == 2) {
			return "Rr";
		}
		if (p > cnt / 4 && p <= cnt / 2) {
			return recursive(n - 1, p - cnt / 4);
		}
		return recursive(n - 1, p - cnt / 2);
	}
}