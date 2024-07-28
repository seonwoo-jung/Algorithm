package com.study.algorithm.site.programmers.level_0;

public class Main62 {

	public static void main(String[] args) {
		int solution = solution(20);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			// 모든 약수의 수와 순서쌍의 수는 같다.
			if (n % i == 0) {
				answer++;
			}
		}
		return answer;
	}
}