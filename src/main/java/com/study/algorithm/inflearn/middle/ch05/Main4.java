package com.study.algorithm.inflearn.middle.ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 카드 가져가기
 */
public class Main4 {

	public static void main(String[] args) {
		System.out.println(solution2(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
		System.out.println(solution2(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
		System.out.println(solution2(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
		System.out.println(solution2(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
	}

	private static int solution(int[] nums, int k) {
		int n = nums.length;
		List<Integer> list = new ArrayList<>();

		int[] array = Arrays.stream(nums)
			.boxed()
			.sorted((o1, o2) -> Integer.compare(o2, o1))
			.mapToInt(Integer::intValue)
			.toArray();

		for (int i = 0; i <= n - k; i++) {
			if (Math.abs(array[i] - array[i + k - 1]) <= 10) {
				int sum = 0;
				for (int j = i; j < i + k; j++) {
					sum += array[j];
				}
				list.add(sum / k);
			}
		}

		return list.size() == 1 ? list.get(0) : Collections.min(list);
	}

	private static int solution2(int[] score, int k) {
		int n = score.length;

		Arrays.sort(score);

		for (int i = 0; i <= n - k; i++) {
			if (score[i + k - 1] - score[i] <= 10) {
				return getAve(score, i, i + k - 1);
			}
		}

		return 0;
	}

	private static int getAve(int[] score, int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++) {
			sum += score[i];
		}
		return sum / (e - s + 1);
	}
}
