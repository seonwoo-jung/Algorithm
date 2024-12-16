package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.HashSet;
import java.util.Set;

// 최대 길이 연속 수열
public class Main1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}

	private static int solution(int[] nums) {
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		for (int x : set) {
			// 자기보다 1 작은 숫자가 있다는 것은, 시작점이 아니라는 것이기 때문에
			if (set.contains(x - 1)) {
				continue;
			}
			int cnt = 0;
			// 시작지점으로 보이는 숫자가 있으면 연속수열인지 확인한다.
			while (set.contains(x)) {
				cnt++;
				x++;
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
}
