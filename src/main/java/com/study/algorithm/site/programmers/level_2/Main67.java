package com.study.algorithm.site.programmers.level_2;

import java.util.*;

 // todo: 다시보기
public class Main67 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
		System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
	}

	private static int solution(int[] topping) {
		int answer = 0;

		Map<Integer, Integer> map_1 = new HashMap<>(); // 형
		Map<Integer, Integer> map_2 = new HashMap<>(); // 동생

		for (int e : topping) {
			map_2.put(e, map_2.getOrDefault(e, 0) + 1);
		}

		for (int e : topping) {
			map_1.put(e, map_1.getOrDefault(e, 0) + 1);

			if (map_2.get(e) - 1 == 0)
				map_2.remove(e);
			else
				map_2.put(e, map_2.get(e) - 1);

			if (map_1.size() == map_2.size())
				answer++;
		}

		return answer;
	}
}
