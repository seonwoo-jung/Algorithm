package com.study.algorithm.site.programmers.level_0;

/**
 * 다음에 올 숫자
 */
public class Main2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 9, 27, 81, 243}));
	}

	private static int solution(int[] common) {

		int answer = 0;

		if (common[1] - common[0] == common[2] - common[1]) {
			// 등차수열일 경우
			answer = common[common.length - 1] + (common[1] - common[0]);
		} else {
			// 등비수열일 경우
			answer = common[common.length - 1] * (common[1] / common[0]);
		}

		return answer;
	}
}

