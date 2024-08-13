package com.study.algorithm.site.programmers.level_2;

public class Main7 {

	private static int answer = 0;
	private static int N;

	public static void main(String[] args) {
		int solution = solution(15);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n) {
		N = n;
		for (int i = 1; i <= n; i++) {
			dfs(i, 0);
		}
		return answer;
	}

	private static void dfs(int x, int sum) {
		if (sum > N) {

		} else if (sum == N) {
			answer++;
		} else {
			dfs(x + 1, sum + x);
		}
	}
}
