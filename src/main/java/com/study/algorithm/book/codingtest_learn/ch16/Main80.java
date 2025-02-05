package com.study.algorithm.book.codingtest_learn.ch16;

import java.util.Arrays;

public class Main80 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
		System.out.println(solution(new int[]{70, 80, 50}, 100));
	}

	private static int solution(int[] people, int limit) {
		int lt = 0;
		int answer = 0;
		int rt = people.length - 1;
		Arrays.sort(people);

		while (lt <= rt) {
			int sum = people[lt] + people[rt];
			if (limit - sum < 0) {
				answer++;
				rt--;
			} else {
				lt++;
				rt--;
				answer++;
			}
		}

		return answer;
	}
}
