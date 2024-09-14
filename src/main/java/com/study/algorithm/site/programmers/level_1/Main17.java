package com.study.algorithm.site.programmers.level_1;

/**
 * 콜라츠 추측
 */
public class Main17 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
	}

	private static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < signs.length; i++) {
			if (signs[i] == true) {
				answer += absolutes[i];
			} else {
				answer = answer + (absolutes[i] * -1);
			}
		}
		return answer;
	}
}
