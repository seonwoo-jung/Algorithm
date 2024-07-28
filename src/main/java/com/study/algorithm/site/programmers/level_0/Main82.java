package com.study.algorithm.site.programmers.level_0;

import java.util.ArrayList;
import java.util.List;

public class Main82 {
	public static void main(String[] args) {
		int[] solution = solution(10);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) list.add(i);
		}

		return list.stream().mapToInt(x -> x).toArray();
	}
}