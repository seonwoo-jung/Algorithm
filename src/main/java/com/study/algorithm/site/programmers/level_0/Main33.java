package com.study.algorithm.site.programmers.level_0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main33 {
	public static void main(String[] args) {
		int[][] score = {
				{80, 70},
				{70, 80},
				{30, 50},
				{90, 100},
				{100, 90},
				{100, 100},
				{10, 30}
		};
		System.out.println(solution(score));
	}

	static int[] solution(int[][] score) {
		List<Integer> scoreList = new ArrayList<>();

		// row별 합계 후 list에 넣는다.
		for (int[] t : score) {
			scoreList.add(t[0] + t[1]);
		}

		// 내림차순 정렬
		scoreList.sort(Comparator.reverseOrder());

		int[] answer = new int[score.length];


		for (int i = 0; i < score.length; i++) {
			// 합계와 동일한 index를 찾은 뒤 +1을 하고, 배열에 값을 입력한다.
			answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
		}

		return answer;
	}

	static int[] solution2(int[][] score) {
		int[] avg = new int[score.length];

		// 배열 avg에 평균값을 넣는다.
		for (int i = 0; i < score.length; i++) {
			avg[i] = (score[i][0] + score[i][1]) / 2;
		}

		// 순위를 매긴다
		int[] answer = new int[score.length];

		for (int j = 0; j < score.length; j++) {
			int order = 1;
			for (int k = 0; k < score.length; k++) {
				if (avg[j] < avg[k]) {
					order++;
				}
				answer[j] = order;
			}
		}
		return answer;
	}
}
