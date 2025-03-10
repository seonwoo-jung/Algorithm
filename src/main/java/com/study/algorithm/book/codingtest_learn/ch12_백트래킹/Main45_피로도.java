package com.study.algorithm.book.codingtest_learn.ch12_백트래킹;

public class Main45_피로도 {

	private static int answer;
	private static int[][] Dungeons;
	private static boolean[] visited;

	public static void main(String[] args) {
		System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
		System.out.println(solution(80, new int[][]{{80, 40}, {50, 40}, {30, 10}}));
	}

	// 백트래킹을 위한 DFS
	private static void backtrack(int k, int cnt) {
		for (int i = 0; i < Dungeons.length; i++) {
			if (!visited[i] && k >= Dungeons[i][0]) {
				visited[i] = true; // i번째 던전을 방문 처리
				backtrack(k - Dungeons[i][1], cnt + 1);
				answer = Math.max(answer, cnt + 1);
				visited[i] = false; // i번째 던전을 다시 방문 취소
			}
		}
	}

	public static int solution(int k, int[][] dungeons) {
		answer = 0;
		Dungeons = dungeons;
		visited = new boolean[dungeons.length];

		backtrack(k, 0);

		return answer;
	}
}