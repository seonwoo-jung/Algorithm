package com.study.algorithm.book.codingtest_learn.ch01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 실패율
 */
public class Main6 {

	public static void main(String[] args) {
		int[] answer = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
		for (int i : answer) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int N, int[] stages) {
		int[] challenger = new int[N + 2];

		// 스테이지별 도전자 수를 구한다.
		for (int i = 0; i < stages.length; i++) {
			challenger[stages[i]] += 1;
		}

		System.out.println("스테이지별 도전자 수 = " + Arrays.toString(challenger));

		// 스테이지별 실패한 사용자 수 계산
		HashMap<Integer, Double> fails = new HashMap<>();
		double total = stages.length;

		for (int i = 1; i <= N; i++) {
			if (challenger[i] == 0) {
				fails.put(i, 0.);
			} else {
				// 실패율 구함
				fails.put(i, challenger[i] / total);
				// 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
				total -= challenger[i];
			}
		}

		// 실패율이 높은 스테이지부터 내림차순으로 정렬
		return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	}
}
