package com.study.algorithm.inflearn.middle.ch01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 최대 길이 바이토닉 수열
 */
public class Main5 {

	public static void main(String[] args) {
		System.out.println(solution2(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
		System.out.println(solution2(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(solution2(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(solution2(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}

	private static int solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
				map.put(i, 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			for (int i = entry.getKey(); i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					map.put(entry.getKey(), entry.getValue() + 1);
				} else {
					break;
				}
			}

			for (int i = entry.getKey(); i > 0; i--) {
				if (nums[i - 1] < nums[i]) {
					map.put(entry.getKey(), entry.getValue() + 1);
				} else {
					break;
				}
			}
		}

		int[] answer = map.entrySet().stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
			.mapToInt(Entry::getValue).toArray();

		return answer[0];
	}

	private static int solution2(int[] nums) {
		int answer = 0;
		List<Integer> peaks = new ArrayList<>();
		int n = nums.length;

		for (int i = 1; i < n - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}

		for (int x : peaks) {
			int left = x;
			int right = x;
			int cnt = 1;

			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				left--;
				cnt++;
			}

			while (right + 1 < n && nums[right] > nums[right + 1]) {
				right++;
				cnt++;
			}

			answer = Math.max(answer, cnt);
		}

		return answer;
	}
}