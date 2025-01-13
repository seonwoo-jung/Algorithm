package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 음수가 있는 부분 수열
 */
public class Main4_음수가있는부분수열 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
		System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
		System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
		System.out.println(solution(new int[]{-1, 0, 1}, 0));
		System.out.println(solution(new int[]{-1, -1, -1, 1}, 0));
	}

	private static int solution(int[] nums, int m) {
		Map<Integer, Integer> nH = new HashMap<>();
		int answer = 0;
		int sum = 0;
		nH.put(0, 1);

		for (int num : nums) {
			sum += num;
			if (nH.containsKey(sum - m)) {
				answer += nH.get(sum - m);
			}
			nH.put(sum, nH.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}
}
