package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main29 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
		System.out.println("answer = " + Arrays.toString(solution));

		int[] solution1 = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
		System.out.println("answer = " + Arrays.toString(solution1));
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