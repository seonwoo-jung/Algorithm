package com.study.algorithm.programmers.level_1;

import java.util.Arrays;

/**
 * 프로그래머스 - 과일 장수
 */
public class Main53 {

	public static void main(String[] args) {
		System.out.println(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
	}

	public static int solution(int k, int m, int[] score) {
		int answer = 0;
		Arrays.sort(score);
		for (int i = score.length - m; i >= 0; i -= m) {
			answer += score[i] * m;
		}
		return answer;
	}
}
