package com.study.algorithm.book.codingtest_learn.ch11_그래프;

public class Main38_네트워크 {

	private static boolean[] visit;
	private static int[][] computer;

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}

	private static int solution(int n, int[][] computers) {
		int answer = 0;
		computer = computers;
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				dfs(i);
				answer++;
			}
		}

		return answer;
	}

	private static void dfs(int now) {
		visit[now] = true;
		for (int i = 0; i < computer[now].length; i++) {
			if (computer[now][i] == 1 && !visit[now]) {
				dfs(i);
			}
		}
	}
}
