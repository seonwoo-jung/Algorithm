package com.study.algorithm.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - 모의고사
 */
public class Main51 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 2, 3, 4, 5});
		for (int i : solution) {
			System.out.println("i = " + i);
		}
		System.out.println("=============================");
		int[] solution1 = solution(new int[]{1, 3, 2, 4, 2});
		for (int i : solution1) {
			System.out.println("i = " + i);
		}
	}

	public static int[] solution(int[] answers) {
		int[] first = {1, 2, 3, 4, 5}; // 5개씩 반복
		int[] second = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
		int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복
		int[] score = {0, 0, 0}; // 각 수포자들의 점수

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == first[i % 5]) {
				score[0]++;
			}
			if (answers[i] == second[i % 8]) {
				score[1]++;
			}
			if (answers[i] == third[i % 10]) {
				score[2]++;
			}
		}

		// 최대 점수 구하기
		int max = Math.max(score[0], Math.max(score[1], score[2]));

		// 최대 점수를 가진 수포자 리스트 생성
		List<Integer> answ = new ArrayList<>();
		for (int i = 0; i < score.length; i++) {
			if (max == score[i]) {
				answ.add(i + 1);
			}
		}

		int[] answer = new int[answ.size()];

		for (int i = 0; i < answ.size(); i++) {
			answer[i] = answ.get(i);
		}

		return answer;
	}
}
