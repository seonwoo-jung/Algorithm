package com.study.algorithm.programmers.level_0;

public class Main2 {

	public static void main(String[] args) {
		int[] common = {3, 9, 27, 81, 243};
		System.out.println(solution(common));
	}

	static int solution(int[] common) {

		int answer = 0;

		// 등차수열일 경우
		if (common[1] - common[0] == common[2] - common[1]) {
			answer = common[common.length - 1] + (common[1] - common[0]);

			// 등비수열일 경우
		} else {
			answer = common[common.length - 1] * (common[1] / common[0]);
		}

		return answer;
	}
}

