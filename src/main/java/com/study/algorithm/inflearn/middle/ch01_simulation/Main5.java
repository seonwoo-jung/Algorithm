package com.study.algorithm.inflearn.middle.ch01_simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 최대 길이 바이토닉 수열
 */
public class Main5 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
		System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}

	private static int solution(int[] nums) {
		int answer = 0;
		List<Integer> peaks = new ArrayList<>();
		int n = nums.length;

		for (int i = 1; i < n - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}

		for (int x : peaks) {
			int lt = x;
			int rt = x;
			int cnt = 1;

			while (lt - 1 >= 0 && nums[lt - 1] < nums[lt]) {
				lt--;
				cnt++;
			}

			while (rt + 1 < n && nums[rt] > nums[rt + 1]) {
				rt++;
				cnt++;
			}

			answer = Math.max(answer, cnt);
		}

		return answer;
	}
}