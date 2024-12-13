package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.Arrays;
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
		int answer = 1;
		nums = Arrays.stream(nums).distinct().sorted().toArray();
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length - 1; i++) {
			int val = nums[i];
			int count = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (val + 1 == nums[j]) {
					val = nums[j];
					count++;
				}
			}
			answer = Math.max(answer, count);
		}

		return answer;
	}

	private static int solution2(int[] nums) {
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		for (int x : set) {
			if (set.contains(x - 1)) {
				continue;
			}
			int cnt = 0;
			while (set.contains(x)) {
				cnt++;
				x++;
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
}
