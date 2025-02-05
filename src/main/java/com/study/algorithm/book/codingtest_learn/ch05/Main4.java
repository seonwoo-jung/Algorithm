package com.study.algorithm.book.codingtest_learn.ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 모의고사
 */
public class Main4 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
	}

	private static int[] solution(int[] answers) {
		int[][] pattern = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};

		int[] scores = new int[3];

		// 1번 방법
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				if (answers[i] == pattern[j][i % pattern[j].length]) {
					scores[j]++;
				}
			}
		}

		int maxScore = Arrays.stream(scores).max().getAsInt();

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] == maxScore) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
