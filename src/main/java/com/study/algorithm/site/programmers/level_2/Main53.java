package com.study.algorithm.site.programmers.level_2;

public class Main53 {

	public static void main(String[] args) {
		System.out.println(solution(1073741824));
	}

	private static int solution(int n) {
		int k = Integer.bitCount(n);
		int answer = 0;

		for (int i = 1; i < n; i++) {
			if (Integer.bitCount(i) == k) {
				answer++;
			}
		}

		return answer;
	}
}