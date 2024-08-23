package com.study.algorithm.book.codingtest_learn.ch16;

public class Main82 {

	public static void main(String[] args) {
		int solution1 = solution(11, new int[]{4, 11}, 1);
		int solution2 = solution(16, new int[]{9}, 2);
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
	}

	private static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int location = 1;
		int idx = 0;

		while (location <= n) {
			if (idx < stations.length && location >= stations[idx] - w) {
				location = stations[idx] + w + 1;
				idx++;
			} else {
				location += 2 * w + 1;
				answer++;
			}
		}
		return answer;
	}
}
