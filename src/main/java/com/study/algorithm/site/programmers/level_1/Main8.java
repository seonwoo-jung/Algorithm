package com.study.algorithm.site.programmers.level_1;

import java.util.ArrayList;

public class Main8 {

	public static void main(String[] args) {
		int x = 2, n = 5;
		solution(x, n);
	}

	private static long[] solution(long x, int n) {
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(x * i);
		}

		return list.stream().mapToLong(Long::longValue).toArray();
	}
}
