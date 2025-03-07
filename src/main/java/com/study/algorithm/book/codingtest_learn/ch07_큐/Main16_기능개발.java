package com.study.algorithm.book.codingtest_learn.ch07_큐;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 기능 개발
 */
public class Main16_기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
		System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
	}

	private static int[] solution(int[] progresses, int[] speeds) {
		ArrayDeque<Integer> answer = new ArrayDeque<>();

		int n = progresses.length;
		int[] daysLeft = new int[n];

		for (int i = 0; i < n; i++) {
			daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
		}

		int count = 0;
		int maxDay = daysLeft[0];

		for (int i = 0; i < n; i++) {
			if (daysLeft[i] <= maxDay) {
				count++;
			} else {
				answer.add(count);
				count = 1;
				maxDay = daysLeft[i];
			}
		}
		answer.add(count);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
