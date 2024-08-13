package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main6 {

	public static void main(String[] args) {
		int[] solution = solution("110010101001");
		System.out.println("solution = " + Arrays.toString(solution));
	}

	private static int[] solution(String s) {
		int[] answer = new int[2];

		while (s.length() > 1) {

			int cntOne = 0;
			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) == '0') {
					answer[1]++;
				} else {
					cntOne++;
				}
			}

			s = Integer.toBinaryString(cntOne);
			answer[0]++;
		}

		return answer;
	}
}
