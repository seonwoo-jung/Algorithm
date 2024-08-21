package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main12 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
		System.out.println(solution(new int[]{70, 80, 50}, 100));
	}

	private static int solution(int[] people, int limit) {
		int answer = 0;
		int first = 0;
		int last = people.length - 1;

		Arrays.sort(people);

		while (first <= last) {
			answer += 1;
			if (people[first] + people[last] <= limit) {
				first += 1;
			}
			last -= 1;
		}
		return answer;
	}
}
