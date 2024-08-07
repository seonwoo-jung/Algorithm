package com.study.algorithm.site.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스
 */
public class Main64 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();

		for (int x : ingredient) {
			list.add(x);
		}

		int cnt = 0;

		A: while (cnt < 1_000_000) {
			for (int i = 0; i < list.size() - 3; i++) {
				String x = list.get(i) + "" + list.get(i + 1) + "" + list.get(i + 2) + "" + list.get(i + 3);
				if ("1234".equals(x)) {
					list.remove(i);
					list.remove(i + 1);
					list.remove(i + 2);
					list.remove(i + 3);
					continue A;
				}
			}
		}

		return answer;

	}
}
