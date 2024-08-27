package com.study.algorithm.site.programmers.level_2;

public class Main22 {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

	private static int solution(int n) {
		int answer = 0;

		for (int start = 1; start <= n; start++) {
			int sum = 0;
			for (int i = start; i <= n; i++) {
				sum += i;
				if (sum == n) {
					answer++;
					break;
				} else if (sum > n) {
					break;
				}
			}
		}

		return answer;
	}
}
