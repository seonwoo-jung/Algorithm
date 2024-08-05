package com.study.algorithm.site.programmers.level_1;

/**
 * 프로그래머스 - 덧칠하기
 */
public class Main54 {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, new int[]{2, 3, 6}));
		System.out.println(solution(5, 4, new int[]{1, 3}));
		System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
	}

	public static int solution(int n, int m, int[] section) {
		int answer = 0;

		int position = 1;
		for (int i = 0; i < section.length; i++) {
			if (position <= section[i]) {
				answer += 1;
				position = section[i] + m;
			}
		}

		return answer;
	}
}
